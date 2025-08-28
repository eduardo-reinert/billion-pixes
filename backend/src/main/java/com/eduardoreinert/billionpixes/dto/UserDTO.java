package com.eduardoreinert.billionpixes.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

    private String username;
    @NotNull(message = "Email cannot be blank")
    @Size(min = 10, max = 255)
    private String email;
    @NotNull(message = "Password cannot be blank")
    @Size(min = 4, max = 255)
    private String password;
}
