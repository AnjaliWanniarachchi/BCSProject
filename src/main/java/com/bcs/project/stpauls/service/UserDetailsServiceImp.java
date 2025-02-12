package com.bcs.project.stpauls.service;

import com.bcs.project.stpauls.model.User;
import com.bcs.project.stpauls.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailsServiceImp(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public Optional<User> getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    public boolean updateUserToken(String email, String newToken) {
        Optional<User> optionalUser = repository.findByEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setToken(newToken); // Assuming User has a `setToken` method
            repository.save(user); // Save updated user in the database
            return true;
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
}
