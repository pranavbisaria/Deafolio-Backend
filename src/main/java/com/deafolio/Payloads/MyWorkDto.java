package com.deafolio.Payloads;

import com.deafolio.Models.innerContent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MyWorkDto {
    private List<innerContent> myWork;
}
