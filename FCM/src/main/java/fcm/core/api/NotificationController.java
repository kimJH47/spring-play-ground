package fcm.core.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import fcm.core.notification.service.NotificationService;
import fcm.core.notification.dto.request.ReadAlarmRequest;
import fcm.core.notification.dto.request.DeleteAlarmRequest;
import fcm.core.notification.dto.response.FindAlarmResponse;

@RestController
public class NotificationController {

	private final NotificationService notificationService;

	public NotificationController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@GetMapping("/api/alarm")
	public ResponseEntity<FindAlarmResponse> findAlarms(Long memberId) {
		return ResponseEntity.ok(notificationService.findAll(memberId));
	}

	@DeleteMapping("/api/alarm")
	public ResponseEntity<?> delete(Long memberId, DeleteAlarmRequest request) {
		notificationService.delete(memberId, request.getUuid());
		return ResponseEntity.ok()
			.build();
	}

	@PostMapping("api/alarm/read")
	public ResponseEntity<?> readAlarm(Long memberId, ReadAlarmRequest request) {
		notificationService.read(memberId, request.getUuid());
		return ResponseEntity.ok()
			.build();
	}
}
