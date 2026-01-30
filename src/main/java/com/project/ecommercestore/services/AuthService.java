package com.project.ecommercestore.services;

import com.project.ecommercestore.entities.User;
import com.project.ecommercestore.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    public User getCurrentUser() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var userId = (Long) auth.getPrincipal();

        return userRepository.findById(userId).orElse(null);
    }
}
