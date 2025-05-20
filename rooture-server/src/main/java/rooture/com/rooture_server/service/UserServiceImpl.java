package rooture.com.rooture_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import rooture.com.rooture_server.dao.UserDAO;
import rooture.com.rooture_server.model.UserModel;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
private UserDAO userDAO;

@Override
public void registerUser(UserModel user) {
    // You may add validation or hashing here
    userDAO.registerUser(user);
}

}
