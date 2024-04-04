package com.keklyndia.russpass.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Hat {
    @Id
    private Long id;
    private String iconPath;
    private String imagePath;
}
