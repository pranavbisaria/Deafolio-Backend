package com.deafolio.Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AboutMeDto {
    private String phoneNumber;
    private String age;
    private String DOB;
    private String gender;
}
