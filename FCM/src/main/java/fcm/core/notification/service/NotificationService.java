package fcm.core.notification.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fcm.core.notification.infra.NotificationRepository;
import fcm.core.notification.dto.response.AlarmDto;
import fcm.core.notification.dto.response.FindAlarmResponse;
import fcm.core.mock.repo.MemberRepository;

@Service
public class NotificationService {

	private final NotificationRepository notificationRepository;
	private final MemberRepository memberRepository;

	public NotificationService(NotificationRepository notificationRepository, MemberRepository memberRepository) {
		this.notificationRepository = notificationRepository;
		this.memberRepository = memberRepository;
	}

	@Transactional(readOnly = true)
	public FindAlarmResponse findAll(Long memberId) {
		// memberRepository.existsId(memberId);
		return new FindAlarmResponse(notificationRepository.findByMemberId(memberId).stream()
			.map(AlarmDto::create)
			.collect(Collectors.toList()));
	}

	@Transactional
	public void delete(Long memberId, String uuid) {
		// memberRepository.existsId(memberId);
		notificationRepository.deleteByUuid(uuid);
	}

	@Transactional
	public void read(Long memberId, String uuid) {
		// memberRepository.existsId(memberId);
		notificationRepository.findByUuid(uuid)
			.orElseThrow(() -> new IllegalArgumentException("없어요 알림이"))
			.read();
	}
}
