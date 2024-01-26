package fcm.core.notification.entity;


public enum Type {
	REPLY("대댓글 알림");

	private final String description;

	Type(String description) {
		this.description = description;
	}
}
