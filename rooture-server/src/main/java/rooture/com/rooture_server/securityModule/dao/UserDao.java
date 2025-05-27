package rooture.com.rooture_server.securityModule.dao;

import rooture.com.rooture_server.securityModule.model.User;

public interface UserDao {
    User findByUsername(String username);
}
