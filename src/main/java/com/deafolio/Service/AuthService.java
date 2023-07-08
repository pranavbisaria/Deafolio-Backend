package com.deafolio.Service;

import com.deafolio.Payloads.*;
import com.deafolio.Security.JwtAuthRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> LoginAPI(JwtAuthRequest request);

    ResponseEntity<?> registerEmail(EmailDto emailDto);

    ResponseEntity<?> verifyToRegister(SignupDto userDto);

    ResponseEntity<?> resetPassword(ForgetPassword forgetPassword);

    ResponseEntity<?> verifyOTPPasswordChange(PasswordOTPVerifyDto otpDto);

    ResponseEntity<?> sendOTPForget(PasswordChangeDto emailDto) throws Exception;
}
