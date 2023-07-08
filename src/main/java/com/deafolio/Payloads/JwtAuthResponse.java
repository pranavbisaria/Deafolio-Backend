package com.deafolio.Payloads;

import com.deafolio.Models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthResponse {
    private String accessToken;
    private String fullName;
    private String Email;
    private Set<Role> roles;
}
