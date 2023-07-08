package com.deafolio.Service.Impl;

import com.deafolio.Models.User;
import com.deafolio.Payloads.UserProfile;
import com.deafolio.Service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.OK;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ModelMapper modelMapper;
    @Override
    public ResponseEntity<?> getProfile(User user){
        return ResponseEntity.status(OK).body(this.modelMapper.map(user, UserProfile.class));
    }
}
