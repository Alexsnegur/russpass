package com.keklyndia.russpass.entity;

import com.keklyndia.russpass.dto.RewardedHatDto;
import com.keklyndia.russpass.repository.UserRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class RewardHat extends Reward {
    @OneToOne
    private Hat hat;

    @Override
    public Object processReward(User user) {
        user.getOwnedHats().add(hat);
        return RewardedHatDto.builder()
                .iconPath(hat.getIconPath())
                .build();

    }
}
