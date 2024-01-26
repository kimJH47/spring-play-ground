package fcm.core.notification.dto.request;

import jakarta.validation.constraints.NotBlank;

public class ReadAlarmRequest {

	public ReadAlarmRequest(String uuid) {
		this.uuid = uuid;
	}

	public ReadAlarmRequest() {
	}

	@NotBlank(message = "알림의 고유번호는 필수로 필요합니다.")
	private String uuid;

	public String getUuid() {
		return uuid;
	}
}
