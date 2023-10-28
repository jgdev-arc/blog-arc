package com.tlz.blogarc.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {

    private Long id;

    @NotEmpty(message = "Must enter a first name.")
    private String firstName;

    @NotEmpty(message = "Must enter a last name.")
    private String lastName;

    @NotEmpty(message = "Please enter a valid email address.")
    @Email
    private String email;

    @NotEmpty(message = "Please enter a valid password.")
    private String password;
}
