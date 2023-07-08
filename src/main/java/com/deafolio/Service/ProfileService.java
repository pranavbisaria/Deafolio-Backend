package com.deafolio.Service;

import com.deafolio.Models.User;
import org.springframework.http.ResponseEntity;

public interface ProfileService {
    ResponseEntity<?> getProfile(User user);
}
