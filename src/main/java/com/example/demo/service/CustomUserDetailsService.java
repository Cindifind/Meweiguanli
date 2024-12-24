package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        logUserDetails(user);

        return new CustomUserDetails(user);
    }

    private void logUserDetails(User user) {
        logger.info("Loaded user: {}", user);
        logger.info("User ID: {}", user.getId());
        logger.info("User Department Name: {}", user.getDepartment_name());
        logger.info("User Username: {}", user.getUsername());
        logger.info("User Enabled: {}", user.getEnabled());
        logger.info("User Roles: {}", user.getAuthorities().stream()
                .map(authority -> "ROLE_" + authority.getAuthority())
                .collect(Collectors.joining(", ")));
    }
}
