package rooture.com.rooture_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rooture.com.rooture_server.model.UserModel;
import rooture.com.rooture_server.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
private UserService userService;

@PostMapping("/register")
public ResponseEntity<String> registerUser(@RequestBody UserModel user) {
    userService.registerUser(user);
    return ResponseEntity.ok("User registered successfully.");
}

}