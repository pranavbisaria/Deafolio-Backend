package com.deafolio.Controllers;

import com.deafolio.Models.User;
import com.deafolio.Security.CurrentUser;
import com.deafolio.Service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/profile")
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/get")
    public ResponseEntity<?> getProfile(@CurrentUser User user){
        return this.profileService.getProfile(user);
    }
}
