package com.keklyndia.russpass.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Reward {
    @Id
    Long id;

    public abstract Object processReward(User user);
}
