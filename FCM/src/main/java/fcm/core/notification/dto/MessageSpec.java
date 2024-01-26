package fcm.core.notification.dto;

import java.util.Map;

public class MessageSpec {
	private String title;
	private String body;
	private Map<String, String> data;

	public MessageSpec(String title, String body, Map<String, String> data) {
		this.title = title;
		this.body = body;
		this.data = data;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public Map<String, String> getData() {
		return data;
	}
}
