package com.deafolio.Payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SignupDto {
    @Min(value=100000, message="OTP should be 6 digit number")
    @Digits(message="OTP should be 6 digit number", fraction = 0, integer = 6)
    private Integer otp;
    @NotEmpty
    @Email(message = "Email Address is not Valid!!")
    private String email;
}
