package com.deafolio.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class innerContent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public innerContent(String name, String about) {
        this.name = name;
        this.about = about;
    }

    private String name;
    private String about;
}
