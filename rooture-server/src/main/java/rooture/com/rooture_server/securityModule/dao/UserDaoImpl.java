package rooture.com.rooture_server.securityModule.dao;

@Service
public class UserDaoImpl implements UserDao {
    @Override
    public User findByUsername(String username) {
        if ("admin".equals(username)) {
            User user = new User();
            user.setId(1L);
            user.setUsername("admin");
            user.setPassword("encrypted-password");
            user.setRole("ADMIN");
            return user;
        }
        return null;
    }
}
