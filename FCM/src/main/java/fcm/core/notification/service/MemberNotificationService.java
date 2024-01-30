package fcm.core.notification.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fcm.core.notification.entity.MemberNotification;
import fcm.core.notification.infra.MemberNotificationRepository;
import fcm.core.mock.repo.MemberRepository;

@Service
public class MemberNotificationService {

	private final MemberRepository memberRepository;
	private final MemberNotificationRepository memberNotificationRepository;

	public MemberNotificationService(MemberRepository memberRepository, MemberNotificationRepository memberNotificationRepository) {
		this.memberRepository = memberRepository;
		this.memberNotificationRepository = memberNotificationRepository;
	}

	@Transactional
	public void addToken(Long memberId, String token) {

		//memberRepository.existsByMemberId(memberId);

		if (memberNotificationRepository.existsByMemberId(memberId)) {
			updateToken(memberId, token);
			return;
		}

		MemberNotification memberFcm = new MemberNotification(null, memberId, token);
		memberNotificationRepository.save(memberFcm);
	}

	private void updateToken(Long memberId, String token) {
		MemberNotification memberNotification = memberNotificationRepository.findByMemberId(memberId)
			.orElseThrow(() -> new IllegalArgumentException("토큰 없뜸"));
		memberNotification.updateToken(token);
	}
}
