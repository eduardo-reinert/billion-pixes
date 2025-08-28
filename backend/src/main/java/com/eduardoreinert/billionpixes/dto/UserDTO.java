package com.eduardoreinert.billionpixes.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {

    private String username;
    @NotNull(message = "Email cannot be blank")
    private String email;
    private String password;
}
