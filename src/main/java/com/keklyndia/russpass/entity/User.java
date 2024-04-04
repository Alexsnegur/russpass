package com.keklyndia.russpass.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

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

    @OneToMany
    private List<Hat> ownedHats;

    public User(String username, String email, Date registrationDate, int score, List<Hat> ownedHats) {
        this.username = username;
        this.email = email;
        this.registrationDate = registrationDate;
        this.score = score;
        this.ownedHats = ownedHats;
    }
}
