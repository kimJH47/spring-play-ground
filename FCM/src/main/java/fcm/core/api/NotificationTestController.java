package fcm.core.api;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fcm.core.fcm.infra.FcmClient;
import fcm.core.notification.dto.MessageSpec;

@RestController
public class NotificationTestController {
	private final FcmClient fcmClient;

	public NotificationTestController(FcmClient fcmClient) {
		this.fcmClient = fcmClient;
	}

	@GetMapping("/api/test/noti/{token}")
	public ResponseEntity<?> testNotification(@PathVariable String token) {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("data", "1");
		MessageSpec messageSpec = new MessageSpec("그 타이틀", "그 제목", hashMap);
		fcmClient.pub(messageSpec, token);
		return ResponseEntity.ok().build();
	}
}
