package com.deafolio.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service @RequiredArgsConstructor
@Slf4j
public class OTPService {
    private final EmailService emailService;

    public int OTPRequest(String email) {
        Random rand = new Random();
        int otpCheck = rand.nextInt(899999) + 100000;
        String subject = "OTP Verification";
        String message = "Dear User," +
                "\nThe One Time Password (OTP) to verify your Email Address is " + otpCheck +
                "\nThe One Time Password is valid for the next 10 minutes." +
                "\n(This is an auto generated email, so please do not reply back. Email at pranavbisariya29@gmail.com)" +
                "\nRegards," +
                "\nTeam Deafolio";
        String to = email;
        this.emailService.sendEmail(subject, message, to);
        return otpCheck;
    }

    public void SuccessRequest(String email, String name) {
        String subject = "Successfully registered on Deafolio Platform";
        String message = "Dear " + name + "," +
                "\nThank you for registering on Deafolio" +
                "\nUnlocking Opportunities in Silence: Deafolio - Empowering All Individuals to Thrive" +
                "\n(This is an auto generated email, so please do not reply back. Email at pranavbisariya29@gmail.com)" +
                "\nRegards," +
                "\nTeam Deafolio";
        String to = email;
        this.emailService.sendEmail(subject, message, to);
    }
}