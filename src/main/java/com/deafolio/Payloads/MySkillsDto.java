package com.deafolio.Payloads;

import com.deafolio.Models.Skills;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MySkillsDto {
    private List<Skills> mySkills;
}
