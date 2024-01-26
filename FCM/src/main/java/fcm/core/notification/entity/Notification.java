package fcm.core.notification.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long memberId;
	private String uuid;
	private String message;
	private Long markId;
	private Type type;
	private boolean isRead;

	private LocalDateTime createdAt;

	public Notification(Long id, String uuid, Long memberId, boolean isRead) {
		this.id = id;
		this.uuid = uuid;
		this.memberId = memberId;
		this.isRead = isRead;
	}

	public Notification() {

	}

	public Long getMemberId() {
		return memberId;
	}

	public String getUuid() {
		return uuid;
	}

	public String getMessage() {
		return message;
	}

	public Long getMarkId() {
		return markId;
	}

	public Type getType() {
		return type;
	}

	public boolean isRead() {
		return isRead;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void read() {
		isRead = true;
	}
}
