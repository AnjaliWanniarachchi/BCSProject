package com.bcs.project.stpauls.controller;

import com.bcs.project.stpauls.model.AuthenticationResponse;
import com.bcs.project.stpauls.model.PasswordResetRequest;
import com.bcs.project.stpauls.model.User;
import com.bcs.project.stpauls.service.AuthenticationService;
import com.bcs.project.stpauls.service.UserDetailsServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://stpaulspreschool.s3-website.eu-north-1.amazonaws.com:4200")
@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserDetailsServiceImp userDetailsService;

    public AuthenticationController(AuthenticationService authService, UserDetailsServiceImp userDetailsService) {
        this.authService = authService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody User request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody User request
    ) {
        System.out.println("Login  " + request.getUsername() + "Pw " + request.getPassword());
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Map<String, String>> resetPassword(@RequestBody PasswordResetRequest request) {
        authService.resetPassword(request);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Password reset successful.");
        return ResponseEntity.ok(response);
    }

    private String getTokenForTheUser(String user, List<PasswordResetRequest> listOfRequests){
        for (PasswordResetRequest request : listOfRequests){
            if(request.getUser().equals(user)){
               return request.getToken();
            }
        }
        return "";
    }

    @PostMapping("/generate-reset-token")
    public ResponseEntity<?> generateResetToken(@RequestBody Map<String, String> request) {
        String email = request.get("email");

        // Generate a unique token
        String token = UUID.randomUUID().toString();
        boolean tokenUpdated = userDetailsService.updateUserToken(email, token);

        if (tokenUpdated) {
            // Return a response with the token and a success message
            return ResponseEntity.ok(Map.of("message", "Password reset token generated successfully.", "token", token));
        } else {
            // Return an error response in case the token update fails
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Failed to generate reset token."));
        }
    }
}
