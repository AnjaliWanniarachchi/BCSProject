package com.bcs.project.stpauls.service;

import com.bcs.project.stpauls.controller.AuthenticationController;
import com.bcs.project.stpauls.model.AuthenticationResponse;
import com.bcs.project.stpauls.model.User;
import com.bcs.project.stpauls.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JWTService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(User reqest){
        User user = new User();
        user.setUserName(reqest.getUserName());
        user.setPassword(passwordEncoder.encode(reqest.getPassword()));
        user.setRole(reqest.getRole());
        user = repository.save(user);
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(User request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        User user = repository.findByUsername(request.getUserName()).orElseThrow();
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }
}
