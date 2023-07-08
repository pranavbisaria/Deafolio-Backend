package com.deafolio.Service;

import com.deafolio.Exceptions.ResourceNotFoundException;
import com.deafolio.Models.User;
import com.deafolio.Payloads.ApiResponse;
import com.deafolio.Payloads.JwtAccessTokenResponse;
import com.deafolio.Payloads.JwtAuthResponse;
import com.deafolio.Repository.UserRepo;
import com.deafolio.Security.JwtTokenHelper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@Service @RequiredArgsConstructor
public class JWTTokenGenerator {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenHelper jwtTokenHelper;
    private final UserDetailsService userDetailsService;
    private final UserRepo userRepo;

    private boolean authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            this.authenticationManager.authenticate(authenticationToken);
            return true;
        } catch (BadCredentialsException var5) {
            System.out.println("Invalid Password");
            return false;
        }
    }

    public JwtAuthResponse getTokenGenerate(String email, String Password) {
        if (this.authenticate(email, Password)) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
            String myAccessToken = this.jwtTokenHelper.generateAccessToken(userDetails);
            JwtAuthResponse response = new JwtAuthResponse();
            response.setAccessToken(myAccessToken);
            return response;
        } else {
            return null;
        }
    }
}
