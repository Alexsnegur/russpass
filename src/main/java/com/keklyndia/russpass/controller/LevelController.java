package com.keklyndia.russpass.controller;

import com.keklyndia.russpass.dto.GiveXpDto;
import com.keklyndia.russpass.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/level")
public class LevelController {
    private final LevelService levelService;

    @PutMapping("/xp")
    ResponseEntity<?> giveXp(@RequestBody GiveXpDto dto) {
        var ok = levelService.giveXp(dto.getUserId(), dto.getAmount());

        return ok
                ? ResponseEntity.ok("ok")
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{userId}")
    ResponseEntity<?> getLevel(@PathVariable Long userId) {
        var level = levelService.getLevel(userId);
        return (level != null)
                ? ResponseEntity.ok(level)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/xp/{userId}")
    ResponseEntity<?> getXp(@PathVariable Long userId) {
        var xp = levelService.getXp(userId);
        return (xp != null)
                ? ResponseEntity.ok(xp)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
