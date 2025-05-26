package rooture.com.rooture_server.securityModule.dao;

public interface UserDao {
    User findByUsername(String username);
}
