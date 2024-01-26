package fcm.core.notification.dto.request;

import jakarta.validation.constraints.NotBlank;

public class DeleteAlarmRequest {

	public DeleteAlarmRequest(String uuid) {
		this.uuid = uuid;
	}

	public DeleteAlarmRequest() {
	}

	@NotBlank(message = "알림의 고유번호는 필수로 필요합니다.")
	private String uuid;

	public String getUuid() {
		return uuid;
	}
}
