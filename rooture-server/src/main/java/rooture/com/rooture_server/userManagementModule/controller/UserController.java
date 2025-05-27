package rooture.com.rooture_server.userManagementModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rooture.com.rooture_server.userManagementModule.dto.LoginDTO;
import rooture.com.rooture_server.userManagementModule.dto.RoleDTO;
import rooture.com.rooture_server.userManagementModule.dto.UserDTO;
import rooture.com.rooture_server.userManagementModule.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.registerUser(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(userService.loginUser(loginDTO));
    }

    @GetMapping("/profile/{username}")
    public ResponseEntity<UserDTO> getProfile(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserProfile(username));
    }

    @PutMapping("/profile")
    public ResponseEntity<String> updateProfile(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUserProfile(userDTO));
    }

    @PostMapping("/role")
    public ResponseEntity<String> assignRole(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.ok(userService.assignRole(roleDTO));
    }
}
