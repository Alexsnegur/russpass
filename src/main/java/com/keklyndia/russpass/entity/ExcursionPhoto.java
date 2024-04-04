package com.keklyndia.russpass.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "excursion_photos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExcursionPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private Long photoId;

    @Column(name = "excursion_id")
    private Long excursionId;

    @Column(name = "photo_url", columnDefinition = "TEXT")
    private String photoUrl;


}
