package com.deafolio.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.formatter.qual.Format;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Company name Can't be blank")
    private String companyName;
    @NotBlank(message = "Job profile Can't be blank")
    private String jobProfile;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Skills> skillsRequired;
    private LocalDateTime applyBy;
    private String location;
    private String availability;
    private String expectation;
    private String jobType;
}
