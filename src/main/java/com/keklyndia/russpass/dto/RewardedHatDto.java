package com.keklyndia.russpass.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RewardedHatDto {
    private final String type = "hat";
    private String iconPath;
}
