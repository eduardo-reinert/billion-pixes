package com.eduardoreinert.billionpixes.service;

import com.eduardoreinert.billionpixes.dto.UserDTO;
import com.eduardoreinert.billionpixes.exception.InvalidCredentialsException;
import com.eduardoreinert.billionpixes.exception.PostgresException;
import com.eduardoreinert.billionpixes.model.User;
import com.eduardoreinert.billionpixes.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        logger.info("Creating user...");
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());

        String hashPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(hashPassword);

        try {
            userRepository.save(user);
            logger.info("{}", "User created successfully.");
            return true;
        } catch (Exception e) {
            logger.error("{}: {}", "Error inserting user into database", e.getMessage());
            throw new PostgresException("Error inserting user into database. Please contact developer for more info.");
        }
    }

    public void getUser(UserDTO userDTO) {

        logger.info("Getting user...");

        Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());

        if (optionalUser.isPresent()) {
            if (!verifyPassword(userDTO.getPassword(), optionalUser.get().getPassword())) {
                logger.error("{}: {}", "Wrong password for user with email", userDTO.getEmail());
                throw new InvalidCredentialsException("Wrong password.");
            }
        }

        if (optionalUser.isEmpty()) {
            logger.error("{}: {}", "Email not found in users table", userDTO.getEmail());
            throw new InvalidCredentialsException("Email not found in users.");
        }

    }

    private boolean verifyPassword(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword, hashedPassword);
    }
}
