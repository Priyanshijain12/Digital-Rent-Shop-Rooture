package rooture.com.rooture_server.dao;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Repository;
import rooture.com.rooture_server.model.UserModel;

@Repository
public class UserDAOImpl implements UserDAO {
    @Override
public void registerUser(UserModel user) {
    // Simulated SQL insert
    System.out.println("INSERT INTO users (username, password, email, phone, role) VALUES (" +
        "'" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getEmail() +
        "', '" + user.getPhone() + "', '" + user.getRole() + "')");
}

@Override
public UserModel findUserByUsername(String username) {
    // Simulated SQL query
    System.out.println("SELECT * FROM users WHERE username = '" + username + "'");
    return null; // dummy value
}

}
