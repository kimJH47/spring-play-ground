package fcm.core.notification.infra;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fcm.core.notification.entity.MemberNotification;

public interface MemberNotificationRepository extends JpaRepository<MemberNotification, Long> {
	boolean existsByMemberId(Long memberId);
	Optional<MemberNotification> findByMemberId(Long memberId);
}
