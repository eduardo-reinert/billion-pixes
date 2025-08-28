package com.eduardoreinert.billionpixes.controller;

import com.eduardoreinert.billionpixes.dto.UserDTO;
import com.eduardoreinert.billionpixes.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final String USER = "user";
    private static final String RESULT = "result";
    private static final String OK = "OK";
    private static final String FAIL = "FAIL";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<HashMap<String, String>> putUser(@RequestBody UserDTO userDTO) {
        HashMap<String, String> response = new HashMap<>();
        boolean isUserCreated = userService.createUser(userDTO);

        if (isUserCreated) {
            response.put(RESULT, OK);
            response.put(USER, userDTO.toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put(RESULT, FAIL);
            response.put(USER, userDTO.toString());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<String> getUser(@Valid @RequestBody UserDTO userDTO) {
        userService.getUser(userDTO);

        return ResponseEntity.ok("Login successful");
    }
}
