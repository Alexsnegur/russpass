package com.keklyndia.russpass.controller;

import com.keklyndia.russpass.entity.ExcursionPhoto;
import com.keklyndia.russpass.entity.Hotel;
import com.keklyndia.russpass.entity.HotelPhoto;
import com.keklyndia.russpass.service.HotelService;
import com.keklyndia.russpass.util.SaveFIle;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileSystemException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/hotel")
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
