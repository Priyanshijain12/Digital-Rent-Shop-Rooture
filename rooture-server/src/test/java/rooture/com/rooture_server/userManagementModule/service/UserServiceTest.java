package rooture.com.rooture_server.userManagementModule.service;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void registerUser_ShouldReturnSuccessMessage() {
        UserDTO dto = new UserDTO();
        String result = userService.registerUser(dto);
        assertEquals("User registered successfully", result);
    }

    @Test
    void loginUser_ShouldReturnLoginSuccess() {
        LoginDTO dto = new LoginDTO();
        String result = userService.loginUser(dto);
        assertEquals("Login successful", result);
    }

    @Test
    void getUserProfile_ShouldReturnUserDTO() {
        UserDTO result = userService.getUserProfile("john");
        assertNotNull(result);
    }

    @Test
    void updateUserProfile_ShouldReturnUpdateMessage() {
        UserDTO dto = new UserDTO();
        String result = userService.updateUserProfile(dto);
        assertEquals("Profile updated", result);
    }

    @Test
    void assignRole_ShouldReturnAssignMessage() {
        RoleDTO dto = new RoleDTO();
        String result = userService.assignRole(dto);
        assertEquals("Role assigned", result);
    }
}
