package fcm.core.notification.service;

import fcm.core.notification.dto.MessageSpec;

public interface NotificationPublisher {
	void pub(MessageSpec messageSpec, String token);
}
