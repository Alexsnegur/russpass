package com.keklyndia.russpass.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GiveXpDto {
    private Long userId;
    private int amount;
}
