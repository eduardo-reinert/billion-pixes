package com.eduardoreinert.billionpixes.service;

import com.eduardoreinert.billionpixes.dto.UserDTO;
import com.eduardoreinert.billionpixes.model.User;
import com.eduardoreinert.billionpixes.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LogManager.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public boolean createUser(UserDTO userDTO) {
        try {
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());

            String hashPassword = passwordEncoder.encode(userDTO.getPassword());
            user.setPassword(hashPassword);

            userRepository.save(user);
            return true;
        } catch (Exception e) {
            logger.error("Error creating user: {}", e.getMessage());
            return false;
        }
    }
}
