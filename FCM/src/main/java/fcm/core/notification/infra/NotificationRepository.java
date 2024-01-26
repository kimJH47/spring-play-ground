package fcm.core.notification.infra;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fcm.core.notification.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

	List<Notification> findByMemberId(Long memberId);

	void deleteByUuid(String uuid);

	Optional<Notification> findByUuid(String uuid);
}
