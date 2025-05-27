package rooture.com.rooture_server.userManagementModule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rooture.com.rooture_server.securityModule.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
