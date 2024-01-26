package fcm.core.notification.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import fcm.core.notification.entity.Notification;
import fcm.core.notification.entity.Type;

public class AlarmDto {
	private final String uuid;
	private final Long markId;
	private final Type type;
	private final String message;
	@JsonFormat(pattern = "yy-MM-ddTHH:mm")
	private final LocalDateTime createAt;

	public AlarmDto(String uuid, Long markId, Type type, String message, LocalDateTime createAt) {
		this.uuid = uuid;
		this.markId = markId;
		this.type = type;
		this.message = message;
		this.createAt = createAt;
	}


	public String getUuid() {
		return uuid;
	}

	public Long getMarkId() {
		return markId;
	}

	public Type getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public static AlarmDto create(Notification notification) {
		return new AlarmDto(notification.getUuid(), notification.getMarkId(), notification.getType(), notification.getMessage(), notification.getCreatedAt());
	}

}
