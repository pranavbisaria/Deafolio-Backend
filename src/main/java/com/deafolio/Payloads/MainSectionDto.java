package com.deafolio.Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MainSectionDto {
    private String fullName;
    private String pronounce;
    private String about;
    private String location;
}