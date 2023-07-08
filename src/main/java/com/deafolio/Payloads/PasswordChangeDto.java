package com.deafolio.Payloads;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordChangeDto {
    @Email(message = "Invalid Email")
    private String email;
}
