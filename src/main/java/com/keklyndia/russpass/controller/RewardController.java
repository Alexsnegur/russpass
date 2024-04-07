package com.keklyndia.russpass.controller;

import com.keklyndia.russpass.dto.TryGetRewardDto;
import com.keklyndia.russpass.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/reward")
public class RewardController {
    private final RewardService rewardService;
    @PutMapping
    ResponseEntity<?> tryGiveReward(@RequestBody TryGetRewardDto dto) {
        var response = rewardService.rewardUser(dto.getUserId(), dto.getRewardId());
        return response != null
                ? ResponseEntity.ok(response)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
