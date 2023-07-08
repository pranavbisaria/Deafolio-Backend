package com.deafolio.Payloads;

import com.deafolio.Models.Role;

import java.util.Set;

public record JwtAccessTokenResponse (
    String accessToken,
    String fullName,
    String Email,
    Set<Role> roles
){}
