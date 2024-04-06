package com.keklyndia.russpass.entity;

import com.keklyndia.russpass.dto.DiscountRewardedDto;
import com.keklyndia.russpass.repository.RewardRepository;
import com.keklyndia.russpass.repository.UserRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class RewardDiscount extends Reward {
    private int amount;
    @Override
    public Object processReward(User user) {
        return DiscountRewardedDto
                .builder()
                .amount(amount)
                .build();
    }
}
