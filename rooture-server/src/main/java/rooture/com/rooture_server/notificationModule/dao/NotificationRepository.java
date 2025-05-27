package rooture.com.rooture_server.notificationModule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rooture.com.rooture_server.notificationModule.model.NotificationLog;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationLog, Long> {
}
