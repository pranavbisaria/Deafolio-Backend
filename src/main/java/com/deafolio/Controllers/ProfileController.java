package com.deafolio.Controllers;

import com.deafolio.Models.User;
import com.deafolio.Payloads.*;
import com.deafolio.Security.CurrentUser;
import com.deafolio.Service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/profile")
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/get")
    public ResponseEntity<?> getProfile(@CurrentUser User user){
        return this.profileService.getProfile(user);
    }

    @PatchMapping("/updateProfilePicture")
    public ResponseEntity<?> updateProfilePicture(@CurrentUser User user, @RequestParam("image") MultipartFile image){
        if (this.profileService.FileValidation(image) && !image.isEmpty())
            return new ResponseEntity<>(new ApiResponse("File is not of image type(JPEG/ JPG or PNG)!!!", false), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        try {
            return this.profileService.updateProfilePicture(user, image);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Can not able to add image", false));
        }
    }

    @PatchMapping("/updateMain")
    public ResponseEntity<?> updateMainSection(@CurrentUser User user, @RequestBody MainSectionDto mainSectionDto){
        return this.profileService.updateMainSection(user, mainSectionDto);
    }
    @PatchMapping("/updateAbout")
    public ResponseEntity<?> updateAboutSection(@CurrentUser User user, @RequestBody AboutMeDto aboutMeDto){
        return this.profileService.updateAboutSection(user, aboutMeDto);
    }
    @PatchMapping("/updateSkills")
    public ResponseEntity<?> updateSkillSection(@CurrentUser User user, @RequestBody MySkillsDto mySkillsDto){
        return this.profileService.updateSkillSection(user, mySkillsDto);
    }
    @PatchMapping("/updateQualification")
    public ResponseEntity<?> updateQualificationSection(@CurrentUser User user, @RequestBody MyQualifications myQualifications){
        return this.profileService.updateQualificationSection(user, myQualifications);
    }
    @PatchMapping("/updateWork")
    public ResponseEntity<?> updateWorkSection(@CurrentUser User user, @RequestBody MyWorkDto myWorkDto){
        return this.profileService.updateWorkSection(user, myWorkDto);
    }
    @PatchMapping("/updateExperience")
    public ResponseEntity<?> updateExperienceSection(@CurrentUser User user, @RequestBody MyExperienceDto myExperienceDto){
        return this.profileService.updateExperienceSection(user, myExperienceDto);
    }
    @PostMapping("/resume")
    public ResponseEntity<?> addResume(@CurrentUser User user, @RequestParam("resume") MultipartFile resume){
        if (this.profileService.FileValidationResume(resume) && !resume.isEmpty())
            return new ResponseEntity<>(new ApiResponse("File is not of image type(JPEG/ JPG or PNG)!!!", false), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        try {
            return this.profileService.addResume(user, resume);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Can not able to add resume", false));
        }
    }
}
