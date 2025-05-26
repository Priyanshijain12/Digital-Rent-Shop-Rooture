package rooture.com.rooture_server.reportingModule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rooture.com.rooture_server.reportingModule.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
