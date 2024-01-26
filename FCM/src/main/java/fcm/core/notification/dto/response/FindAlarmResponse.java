package fcm.core.notification.dto.response;

import java.util.List;

public class FindAlarmResponse {
	private final List<AlarmDto> alarms;

	public FindAlarmResponse(List<AlarmDto> alarms) {
		this.alarms = alarms;
	}

	public List<AlarmDto> getAlarms() {
		return alarms;
	}
}