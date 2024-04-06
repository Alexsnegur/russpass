package com.keklyndia.russpass.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String username;
    private String email;
    @Column(name = "registration_date")
    private Date registrationDate;
    private int score;

    @ManyToOne
    private Hat equippedHat;

    @ManyToMany
    private Set<Hat> ownedHats;
}
