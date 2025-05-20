package rooture.com.rooture_server.dao;

import rooture.com.rooture_server.model.UserModel;

public interface UserDAO {
void registerUser(UserModel user);
UserModel findUserByUsername(String username);
}
