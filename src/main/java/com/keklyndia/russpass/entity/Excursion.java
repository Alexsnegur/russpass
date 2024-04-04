package com.keklyndia.russpass.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.Interval;

import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "excursion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;
    private String name;
    private String city;
    private String address;
    @Column(name = "date_start")
    private Timestamp dateStart;
    @Column(name = "date_end")
    private Timestamp dateEnd;
    @Column(name = "user_ratings_count")
    private int userRatingsCount;
    @Column(name = "average_rating")
    private float averageRating;
    private float price;
    private String description;
}
