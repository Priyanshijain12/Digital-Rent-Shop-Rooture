package rooture.com.rooture_server.adminManagementModule.dao;

import rooture.com.rooture_server.adminManagementModule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}