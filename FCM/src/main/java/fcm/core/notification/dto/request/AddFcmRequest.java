package fcm.core.notification.dto.request;

import jakarta.validation.constraints.NotBlank;

public class AddFcmRequest {
	@NotBlank(message = "FCM 토큰은 필수적으로 필요합니다.")
	private String token;

	public String getToken() {
		return token;
	}
}
