package com.eduardoreinert.billionpixes.service;

import com.eduardoreinert.billionpixes.dto.UserDTO;
import com.eduardoreinert.billionpixes.enums.LogMessagesEnum;
import com.eduardoreinert.billionpixes.exception.InvalidCredentialsException;
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
        try {
            logger.info("Creating user...");
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());

            String hashPassword = passwordEncoder.encode(userDTO.getPassword());
            user.setPassword(hashPassword);

            userRepository.save(user);
            logger.info(LogMessagesEnum.SUCCESS_USER_CREATION.getMessage());
            return true;
        } catch (Exception e) {
            logger.error("{}: {}", LogMessagesEnum.ERROR_USER_CREATION.getMessage(), e.getMessage());
            return false;
        }
    }

    public void getUser(UserDTO userDTO) {

            logger.info("Getting user...");

            Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());

            if (optionalUser.isPresent()) {
                if (!verifyPassword(userDTO.getPassword(), optionalUser.get().getPassword())) {
                    throw new InvalidCredentialsException("Wrong password.");
                }
            }

            if (optionalUser.isEmpty()) {
                throw new InvalidCredentialsException("Email not found in users.");
            }

    }

    private boolean verifyPassword(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword, hashedPassword);
    }
}
