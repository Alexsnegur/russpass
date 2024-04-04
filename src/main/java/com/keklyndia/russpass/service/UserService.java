package com.keklyndia.russpass.service;

import com.keklyndia.russpass.entity.Hotel;
import com.keklyndia.russpass.entity.User;
import com.keklyndia.russpass.repository.HotelRepository;
import com.keklyndia.russpass.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getAllUsersSortByScore() {
        List<User> users = userRepository.findAll();
        Comparator<User> comparator = Comparator.comparing(User::getScore);
        users.sort(comparator.reversed());
        return users;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
