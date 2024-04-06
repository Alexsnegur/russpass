package com.keklyndia.russpass.controller;

import com.keklyndia.russpass.entity.Hotel;
import com.keklyndia.russpass.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/hotel")
@CrossOrigin
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> addNewHotel(@RequestBody Hotel newHotel) {
        hotelService.saveHotel(newHotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHotel);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable(name = "id") Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.ok().body("успешно");
    }

    @GetMapping
    public @ResponseBody Iterable<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Hotel getHotelById(@PathVariable(name = "id") Long id) {
        return hotelService.getHotelById(id);
    }
}
