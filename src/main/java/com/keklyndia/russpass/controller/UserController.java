package com.keklyndia.russpass.controller;

import com.keklyndia.russpass.entity.User;
import com.keklyndia.russpass.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping(path="/add")
    public ResponseEntity<User> addNewUser (@RequestBody User newUser) {
        userService.saveUser(newUser);
        logger.info("Добавлен юзер");
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @DeleteMapping(path="/{id}/delete")
    public ResponseEntity<String> deleteUser (@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        logger.info("Отель удален");
        return ResponseEntity.ok().body("успешно");
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping(path="/{id}")
    public @ResponseBody User getUserById(@PathVariable(name = "id") Long id) {
        return userService.getUserById(id);
    }
    @GetMapping(path="/leaderboard")
    public @ResponseBody Iterable<User> getAllUsersSortByScore() {
        return userService.getAllUsersSortByScore();
    }
}
