package rooture.com.rooture_server.securityModule.controller;

@SpringBootTest
public class SecurityControllerTest {

    @MockBean
    private AuthService authService;

    @Autowired
    private SecurityController securityController;

    @Test
    public void loginWithValidCredentialsReturnsToken() {
        LoginRequest request = new LoginRequest();
        request.setUsername("admin");
        request.setPassword("encrypted-password");

        LoginResponse response = new LoginResponse();
        response.setToken("dummy-jwt-token");
        response.setRole("ADMIN");

        Mockito.when(authService.authenticateUser(request)).thenReturn(response);

        ResponseEntity<LoginResponse> result = securityController.login(request);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals("dummy-jwt-token", result.getBody().getToken());
    }

    @Test
    public void loginWithInvalidCredentialsReturnsUnauthorized() {
        LoginRequest request = new LoginRequest();
        request.setUsername("wrong");
        request.setPassword("wrong");

        Mockito.when(authService.authenticateUser(request)).thenThrow(new RuntimeException("Invalid credentials"));

        ResponseEntity<LoginResponse> result = securityController.login(request);
        Assertions.assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
    }

    @Test
    public void checkAccessReturnsTrueForValidTokenAndRole() {
        Mockito.when(authService.checkAccess("dummy-jwt-token", "ADMIN")).thenReturn(true);

        ResponseEntity<Boolean> result = securityController.checkAccess("dummy-jwt-token", "ADMIN");
        Assertions.assertTrue(result.getBody());
    }

    @Test
    public void checkAccessReturnsFalseForInvalidTokenOrRole() {
        Mockito.when(authService.checkAccess("invalid-token", "USER")).thenReturn(false);

        ResponseEntity<Boolean> result = securityController.checkAccess("invalid-token", "USER");
        Assertions.assertFalse(result.getBody());
    }
}

