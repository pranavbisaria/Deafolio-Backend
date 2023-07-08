package com.deafolio.Payloads;
import com.deafolio.Models.Role;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class OtpDto {
    @Email
    private String email;
    @Min(value=100000, message="OTP should be 6 digit number")
    @Digits(message="OTP should be 6 digit number", fraction = 0, integer = 6)
    private int otp;
    private String fullName;
    private String password;
    private Role role;
    private Boolean active = false;
}