package com.bcs.project.stpauls.controller;

import com.bcs.project.stpauls.model.AuthenticationResponse;
import com.bcs.project.stpauls.model.PasswordResetRequest;
import com.bcs.project.stpauls.model.User;
import com.bcs.project.stpauls.service.AuthenticationService;
import com.bcs.project.stpauls.service.UserDetailsServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://stpaulspreschool.s3-website.eu-north-1.amazonaws.com")
@RestController
public class UserController {
    private final UserDetailsServiceImp userDetailsService;

    public UserController(UserDetailsServiceImp userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/get-user-by-email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userDetailsService.getUserByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/get-user-by-username/{username}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String username) {
        Optional<User> user = userDetailsService.getUserByUserName(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
