package com.eduardoreinert.billionpixes.controller;

import com.eduardoreinert.billionpixes.dto.UserDTO;
import com.eduardoreinert.billionpixes.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<HashMap<String, String>> putUser(@RequestBody UserDTO userDTO) {
        HashMap<String, String> response = new HashMap<>();
        logger.info("Creating user...");
        boolean isUserCreated = userService.createUser(userDTO);

        if (isUserCreated) {
            response.put("User created successfully", userDTO.toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("User not created", userDTO.toString());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
