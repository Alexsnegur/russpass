package com.keklyndia.russpass.controller;

import com.keklyndia.russpass.dto.HatUserDto;
import com.keklyndia.russpass.repository.HatRepository;
import com.keklyndia.russpass.repository.UserRepository;
import com.keklyndia.russpass.service.HatService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/hat")
@CrossOrigin
public class HatController {
    private final HatService service;
    private final UserRepository userRepository;
    private final HatRepository hatRepository;

    @PutMapping("/equip")
    public ResponseEntity<?> equipHat(@RequestBody HatUserDto dto) {
        var user = userRepository.getReferenceById(dto.userId());
        var hat = hatRepository.getReferenceById(dto.hatId());

        boolean ok = service.equipHat(
                user,
                hat
        );

        if (!ok) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("User doesn't own this hat");
        }

        user.setEquippedHat(hat);
        userRepository.save(user);

        return ResponseEntity.ok("ok");
    }

    @GetMapping("/{userId}")
    ResponseEntity<?> getUsersCurrentHat(@PathVariable Long userId) {
        var hat = userRepository
                .getReferenceById(userId)
                .getEquippedHat();
        if (hat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not equipped");
        }

        return ResponseEntity.ok(userRepository
                .getReferenceById(userId)
                .getEquippedHat()
        );
    }

    @PostMapping("/give")
    ResponseEntity<?> giveUserHat(@RequestBody HatUserDto hatUser) {
        boolean ok = service.giveHat(hatUser.userId(), hatUser.hatId());

        if (!ok) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok("ok");
    }

}

