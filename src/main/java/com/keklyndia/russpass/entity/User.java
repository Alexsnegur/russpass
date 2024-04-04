package com.keklyndia.russpass.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    public User(String username, String email, Date registrationDate, int score){
        this.username = username;
        this.email = email;
        this.registrationDate = registrationDate;
        this.score = score;
    }
}
