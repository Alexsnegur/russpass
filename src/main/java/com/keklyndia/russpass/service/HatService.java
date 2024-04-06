package com.keklyndia.russpass.service;

import com.keklyndia.russpass.entity.Hat;
import com.keklyndia.russpass.entity.User;
import com.keklyndia.russpass.repository.HatRepository;
import com.keklyndia.russpass.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HatService {
    private final HatRepository hatRepository;
    private final UserRepository userRepository;

    public boolean equipHat(User user, Hat hat) {
        if (validateUserHasHat(user, hat)) {
            user.setEquippedHat(hat);
            return true;
        }

        return false;
    }

    private boolean validateUserHasHat(User user, Hat hat) {
        return user.getOwnedHats().contains(hat);
    }

    public boolean giveHat(Long userId, Long hatId) {
        if (!userRepository.existsById(userId) || !hatRepository.existsById(hatId)) {
            return false;
        }

        var user = userRepository.getReferenceById(userId);
        user.getOwnedHats().add(hatRepository.getReferenceById(hatId));
        userRepository.save(user);

        return true;
    }
}
