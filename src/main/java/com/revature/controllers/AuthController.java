package com.revature.controllers;

import com.revature.dtos.RequestUser;
import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "http://localhost:5555",
        "http://highscoreio-frontend-bucket.s3-website.us-east-2.amazonaws.com",
        "https://highscoreio-frontend-bucket.s3-website.us-east-2.amazonaws.com"
}, allowedHeaders = "*", exposedHeaders = "*", allowCredentials = "true", maxAge = 2592000)
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/get-user")
    public ResponseEntity<User> getUser(@RequestBody RequestUser requestUser) {
        User user = this.userService.getUser(requestUser);

        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/update-user")
    public ResponseEntity<User> updateUser(@RequestBody RequestUser requestUser) {
        User user = this.userService.saveUser(requestUser);

        return ResponseEntity.ok().body(user);
    }
}
