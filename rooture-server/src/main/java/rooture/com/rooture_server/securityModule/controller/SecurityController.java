package rooture.com.rooture_server.securityModule.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rooture.com.rooture_server.securityModule.model.LoginRequest;
import rooture.com.rooture_server.securityModule.model.LoginResponse;
import rooture.com.rooture_server.securityModule.service.AuthService;

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

