package rooture.com.rooture_server.securityModule.service;

import org.springframework.stereotype.Service;

import rooture.com.rooture_server.securityModule.dao.UserDao;
import rooture.com.rooture_server.securityModule.model.LoginRequest;
import rooture.com.rooture_server.securityModule.model.LoginResponse;
import rooture.com.rooture_server.securityModule.model.User;

@Service
public class AuthService {

    private final UserDao userDao;

    public AuthService(UserDao userDao) {
        this.userDao = userDao;
    }

    public LoginResponse authenticateUser(LoginRequest loginRequest) {
        User user = userDao.findByUsername(loginRequest.getUsername());
        if (user != null && "encrypted-password".equals(loginRequest.getPassword())) {
            LoginResponse response = new LoginResponse();
            response.setToken("dummy-jwt-token");
            response.setRole(user.getRole());
            return response;
        }
        throw new RuntimeException("Invalid credentials");
    }

    public boolean checkAccess(String token, String requiredRole) {
        return "dummy-jwt-token".equals(token) && "ADMIN".equals(requiredRole);
    }
}

