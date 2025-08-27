package com.eduardoreinert.billionpixes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @JsonProperty(value="email")
    @Email
    @Column(name = "email")
    private String email;

    @JsonProperty(value="username")
    @Column(name = "username")
    private String username;

    @JsonProperty(value="password")
    @Column(name = "password_hash")
    private String password;
}
