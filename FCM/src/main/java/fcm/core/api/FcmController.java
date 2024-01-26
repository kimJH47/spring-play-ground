package fcm.core.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fcm.core.notification.service.MemberNotificationService;
import fcm.core.notification.dto.request.AddFcmRequest;
import jakarta.validation.Valid;

@RestController
public class FcmController {

	private final MemberNotificationService memberNotificationService;

	public FcmController(MemberNotificationService memberNotificationService) {
		this.memberNotificationService = memberNotificationService;
	}

	@PostMapping("/api/fcm/add")
	public ResponseEntity<?> addFcm(Long memberId, @RequestBody @Valid AddFcmRequest addFcmRequest) {
		memberNotificationService.addToken(memberId, addFcmRequest.getToken());
		return ResponseEntity.ok()
			.build();
	}


}
