package com.selva.securityjwt.controller;

import com.selva.securityjwt.model.Users;
import com.selva.securityjwt.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users user) {

        String generatedToken = userService.verify(user);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + generatedToken);
        headers.set("Access-Control-Expose-Headers", "Authorization");

        return ResponseEntity.ok()
                .headers(headers)
                .body("Login Sucessful");
    }

}
