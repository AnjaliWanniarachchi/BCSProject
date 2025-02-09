package com.bcs.project.stpauls.controller;

import com.bcs.project.stpauls.model.AuthenticationResponse;
import com.bcs.project.stpauls.model.PasswordResetRequest;
import com.bcs.project.stpauls.model.User;
import com.bcs.project.stpauls.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private List<PasswordResetRequest> listOfTokenMap = new ArrayList<>();
    private List<String> listOfUsersRestPw = new ArrayList<>();

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
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
    public ResponseEntity<String> resetPassword(@RequestBody PasswordResetRequest request) {
        if(listOfUsersRestPw.contains(request.getUser())){
            if(getTokenForTheUser(request.getUser(), listOfTokenMap).equals(request.getToken())){
                authService.resetPassword(request);
                return ResponseEntity.ok("Password reset successful.");
            }
        }
        return ResponseEntity.ofNullable("User is not valid");
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
        String user = request.get("user");

        // Generate a unique token
        String token = UUID.randomUUID().toString();

        // Store the token in the database (mapped to the user)
        PasswordResetRequest tokenMap = new PasswordResetRequest();
        tokenMap.setUser(user);
        tokenMap.setToken(token);
        listOfTokenMap.add(tokenMap);
        listOfUsersRestPw.add(user);
        return ResponseEntity.ok(Map.of("token", token));
    }
}
