package com.deafolio.Service.Impl;

import com.deafolio.Models.User;
import com.deafolio.Payloads.*;
import com.deafolio.Repository.UserRepo;
import com.deafolio.Service.FileServices;
import com.deafolio.Service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.HttpStatus.OK;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    private final FileServices fileServices;
    @Override
    public ResponseEntity<?> getProfile(User user){
        return ResponseEntity.status(OK).body(this.modelMapper.map(user, UserProfile.class));
    }
    @Override
    public ResponseEntity<?> updateMainSection(User user, MainSectionDto mainSectionDto){
        user.setFullName(mainSectionDto.getFullName());
        user.setPronounce(mainSectionDto.getPronounce());
        user.setLocation(mainSectionDto.getLocation());
        user.setAbout(mainSectionDto.getAbout());
        this.userRepo.save(user);
        return ResponseEntity.status(OK).body(this.modelMapper.map(user, UserProfile.class));
    }
    @Override
    public ResponseEntity<?> updateAboutSection(User user, AboutMeDto aboutMeDto){
        user.setPhoneNumber(aboutMeDto.getPhoneNumber());
        user.setAge(aboutMeDto.getAge());
        user.setDOB(aboutMeDto.getDOB());
        user.setGender(aboutMeDto.getGender());
        this.userRepo.save(user);
        return ResponseEntity.status(OK).body(this.modelMapper.map(user, UserProfile.class));
    }
    @Override
    public ResponseEntity<?> updateSkillSection(User user, MySkillsDto mySkillsDto){
        user.setMySkills(mySkillsDto.getMySkills());
        this.userRepo.save(user);
        return ResponseEntity.status(OK).body(this.modelMapper.map(user, UserProfile.class));
    }
    @Override
    public ResponseEntity<?> updateQualificationSection(User user, MyQualifications myQualifications){
        user.setQualifications(myQualifications.getQualifications());
        this.userRepo.save(user);
        return ResponseEntity.status(OK).body(this.modelMapper.map(user, UserProfile.class));
    }
    @Override
    public ResponseEntity<?> updateWorkSection(User user, MyWorkDto myWorkDto){
        user.setMyWork(myWorkDto.getMyWork());
        this.userRepo.save(user);
        return ResponseEntity.status(OK).body(this.modelMapper.map(user, UserProfile.class));
    }
    @Override
    public ResponseEntity<?> updateExperienceSection(User user, MyExperienceDto myExperienceDto){
        user.setMyExperience(myExperienceDto.getMyExperience());
        this.userRepo.save(user);
        return ResponseEntity.status(OK).body(this.modelMapper.map(user, UserProfile.class));
    }
    @Override
    public ResponseEntity<?> updateProfilePicture(User user, MultipartFile image) throws IOException {
        if(user.getProfilePhoto() != null){
            this.fileServices.deleteFiles(user.getProfilePhoto());
        }
        user.setProfilePhoto(this.fileServices.uploadImage(image));
        this.userRepo.save(user);
        return ResponseEntity.status(OK).body(this.modelMapper.map(user, UserProfile.class));
    }
    @Override
    public ResponseEntity<?> addResume(User user, MultipartFile file) throws IOException {
        if(user.getResumeUrl() != null){
            this.fileServices.deleteFiles(user.getResumeUrl());
        }
        user.setResumeUrl(this.fileServices.uploadImage(file));
        this.userRepo.save(user);
        return ResponseEntity.status(OK).body(this.modelMapper.map(user, UserProfile.class));
    }

    @Override
    public boolean FileValidation(MultipartFile image) throws NullPointerException{
        if (!image.getContentType().equals("image/png") && !image.getContentType().equals("image/jpg") && !image.getContentType().equals("image/jpeg") && !image.getContentType().equals("image/webp")) {
            return true;
        }
        return false;
    }
    @Override
    public boolean FileValidationResume(MultipartFile file) throws NullPointerException{
        if (!file.getContentType().equals("image/png") && !file.getContentType().equals("image/jpg") && !file.getContentType().equals("image/jpeg") && !file.getContentType().equals("application/pdf")) {
            return true;
        }
        return false;
    }
}
