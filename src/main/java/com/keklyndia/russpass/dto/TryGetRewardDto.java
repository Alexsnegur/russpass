package com.keklyndia.russpass.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TryGetRewardDto {
    private Long userId;
    private Long rewardId;
}
