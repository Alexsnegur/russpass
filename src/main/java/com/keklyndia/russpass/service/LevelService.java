package com.keklyndia.russpass.service;

import com.keklyndia.russpass.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelService {
    private static final int XP_TO_LEVEL = 1000;
    private final UserRepository userRepository;

    public boolean giveXp(Long userId, int amount) {
        if (!userRepository.existsById(userId)) {
            return false;
        }

        var user = userRepository.getReferenceById(userId);
        int total = user.getXp() + amount;
        int div = total / XP_TO_LEVEL;
        int leftover = total % XP_TO_LEVEL;

        user.setLevel(user.getLevel() + div);
        user.setXp(leftover);
        userRepository.save(user);

        return true;
    }

    public Integer getXp(Long userId) {
        if (!userRepository.existsById(userId)) {
            return null;
        }

        return userRepository.getReferenceById(userId).getXp();
    }

    public Integer getLevel(Long userId) {
        if (!userRepository.existsById(userId)) {
            return null;
        }

        return userRepository.getReferenceById(userId).getLevel();
    }
}
