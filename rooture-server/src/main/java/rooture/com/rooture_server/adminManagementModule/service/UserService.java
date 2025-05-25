package rooture.com.rooture_server.adminManagementModule.service;

import rooture.com.rooture_server.adminManagementModule.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
