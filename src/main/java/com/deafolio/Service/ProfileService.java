package com.deafolio.Service;

import com.deafolio.Models.User;
import com.deafolio.Payloads.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProfileService {
    ResponseEntity<?> getProfile(User user);

    ResponseEntity<?> updateMainSection(User user, MainSectionDto mainSectionDto);

    ResponseEntity<?> updateAboutSection(User user, AboutMeDto aboutMeDto);

    ResponseEntity<?> updateSkillSection(User user, MySkillsDto mySkillsDto);

    ResponseEntity<?> updateQualificationSection(User user, MyQualifications myQualifications);

    ResponseEntity<?> updateWorkSection(User user, MyWorkDto myWorkDto);

    ResponseEntity<?> updateExperienceSection(User user, MyExperienceDto myExperienceDto);

    ResponseEntity<?> updateProfilePicture(User user, MultipartFile image) throws IOException;

    ResponseEntity<?> addResume(User user, MultipartFile file) throws IOException;

    boolean FileValidation(MultipartFile images) throws NullPointerException;

    boolean FileValidationResume(MultipartFile file) throws NullPointerException;
}
