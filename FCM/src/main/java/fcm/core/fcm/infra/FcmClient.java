package fcm.core.fcm.infra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import fcm.core.notification.dto.MessageSpec;
import fcm.core.notification.service.NotificationPublisher;
@Component
public class FcmClient implements NotificationPublisher {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Async
	@Override
	public void pub(MessageSpec messageSpec,String token) {
		// See documentation on defining a message payload.
		Notification notification = Notification.builder()
			.setTitle(messageSpec.getTitle())
			.setBody(messageSpec.getBody())
			.build();

		Message message = Message.builder()
			.setNotification(notification)
			.putAllData(messageSpec.getData())
			.setToken(token)
			.build();
		try {
			String response = FirebaseMessaging.getInstance().send(message);
			logger.info("Successfully sent message: {}",response);
		} catch (FirebaseMessagingException e) {
			logger.error("Failed sent message: {}",e.getMessage());
			throw new IllegalArgumentException(e);
		}
	}
}
