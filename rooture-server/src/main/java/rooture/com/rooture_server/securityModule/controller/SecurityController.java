package rooture.com.rooture_server.securityModule.controller;

@RestController
@RequestMapping("/api/security")
public class SecurityController {

    private final AuthService authService;

    public SecurityController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        try {
            LoginResponse response = authService.authenticateUser(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/check-access")
    public ResponseEntity<Boolean> checkAccess(
            @RequestHeader("Authorization") String token,
            @RequestParam String role) {
        boolean access = authService.checkAccess(token, role);
        return ResponseEntity.ok(access);
    }
}

