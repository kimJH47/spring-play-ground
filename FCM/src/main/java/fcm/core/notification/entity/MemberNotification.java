package fcm.core.notification.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MemberNotification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long memberId;
	private String notificationToken;

	public MemberNotification(Long id, Long memberId, String notificationToken) {
		this.id = id;
		this.memberId = memberId;
		this.notificationToken = notificationToken;
	}

	public MemberNotification() {
	}

	public void updateToken(String token) {
		notificationToken = token;
	}
}
