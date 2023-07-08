package com.deafolio.Payloads;

import com.deafolio.Models.Skills;
import com.deafolio.Models.StringList;
import com.deafolio.Models.innerContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    private String fullName;
    private String pronounce;
    private String about;
    private String location;
    private String phoneNumber;
    private String age;
    private String DOB;
    private String profilePhoto;
    private String gender;
    private List<Skills> mySkills;
    private List<StringList> qualifications;
    private List<innerContent> myWork;
    private List<innerContent> myExperience;
    private String resumeUrl;
}
