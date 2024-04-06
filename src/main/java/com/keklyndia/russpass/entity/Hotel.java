package com.keklyndia.russpass.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long id;
    private String name;
    private String city;
    private String address;
    private boolean wifi;
    private boolean parking;
    private boolean restaurant;
    @Column(name = "user_ratings_count")
    private int userRatingsCount;
    @Column(name = "average_rating")
    private float averageRating;
    @Column(name = "room_price")
    private float roomPrice;
    private String description;
    private String photo;

}
