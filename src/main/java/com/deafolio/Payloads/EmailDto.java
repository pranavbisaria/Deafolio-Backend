package com.deafolio.Payloads;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class EmailDto {
    @NotEmpty
    @Email(message = "Email Address is not Valid!!")
    private String email;
    @NotBlank(message = "Name field can't be blank")
    private String fullName;
    @Size(min = 8, message = "Password must be minimum of 8 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must Contain at least one uppercase letter, one lowercase letter, one numeric character, one special character and no spaces")
    private String password;
}
