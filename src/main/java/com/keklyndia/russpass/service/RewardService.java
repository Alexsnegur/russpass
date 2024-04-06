package com.keklyndia.russpass.service;

import com.keklyndia.russpass.dto.DiscountRewardedDto;
import com.keklyndia.russpass.dto.RewardedHatDto;
import com.keklyndia.russpass.entity.RewardDiscount;
import com.keklyndia.russpass.entity.RewardHat;
import com.keklyndia.russpass.entity.User;
import com.keklyndia.russpass.repository.RewardRepository;
import com.keklyndia.russpass.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RewardService {
    private final UserRepository userRepository;
    private final RewardRepository rewardRepository;
    public Object rewardUser(Long userId, Long rewardId) {
        if (!userRepository.existsById(userId) || !userRepository.existsById(rewardId)) {
            return null;
        }

        var user = userRepository.getReferenceById(userId);
        var reward = rewardRepository.getReferenceById(rewardId);

        var response = reward.processReward(user);
        userRepository.save(user);
        return response;
    }

}
