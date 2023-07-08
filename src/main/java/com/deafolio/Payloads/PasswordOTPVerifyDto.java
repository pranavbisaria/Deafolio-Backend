package com.deafolio.Payloads;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordOTPVerifyDto {
    @Email
    private String email;
    @Min(value=100000, message="OTP should be 6 digit number")
    @Digits(message="OTP should be 6 digit number", fraction = 0, integer = 6)
    private int otp;
}
