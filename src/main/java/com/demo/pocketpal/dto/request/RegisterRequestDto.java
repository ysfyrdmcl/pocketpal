package com.demo.pocketpal.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestDto{
    @Size(min= 3, message = "Email must be valid.")
    @Email(message = "Email must be valid.", regexp = "[a-z0-9]")
    @NotBlank(message = "Email must be valid.")
    @NotNull(message = "Email must be valid.")
    private String email;
    @Size(min= 5, max= 256, message = "Password should have at least 5 characters")
    @NotBlank(message = "Password must be valid.")
    @NotNull(message = "Password must be valid.")
    private String password;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 128)
    private String name;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 128)
    private String lastName;

}
