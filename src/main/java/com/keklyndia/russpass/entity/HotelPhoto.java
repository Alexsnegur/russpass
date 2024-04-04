package com.keklyndia.russpass.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotel_photos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private Long photoId;

    @Column(name = "hotel_id")
    private Long hotelId;

    @Column(name = "photo_url", columnDefinition = "TEXT")
    private String photoUrl;
}
