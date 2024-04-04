package com.keklyndia.russpass.controller;

import com.keklyndia.russpass.entity.ExcursionPhoto;
import com.keklyndia.russpass.entity.Hotel;
import com.keklyndia.russpass.entity.HotelPhoto;
import com.keklyndia.russpass.service.HotelService;
import com.keklyndia.russpass.util.SaveFIle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileSystemException;

@Controller
@RequestMapping(path="/hotel")
public class HotelController {
    Logger logger = LoggerFactory.getLogger(HotelController.class);
    @Autowired
    private HotelService hotelService;

    @PostMapping(path="/add")
    public ResponseEntity<Hotel> addNewHotel (@RequestBody Hotel newHotel) {
        hotelService.saveHotel(newHotel);
        logger.info("Добавлен отель");
        return ResponseEntity.status(HttpStatus.CREATED).body(newHotel);
    }

    @DeleteMapping(path="/{id}/delete")
    public ResponseEntity<String> deleteHotel (@PathVariable(name = "id") Long id) {
        hotelService.deleteHotel(id);
        logger.info("Отель удален");
        return ResponseEntity.ok().body("успешно");
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }
    @GetMapping(path="/{id}/photos")
    public @ResponseBody Iterable<HotelPhoto> getAllPhotoHotel(@PathVariable(name = "id") Long id) {
        return hotelService.getAllPhotoByHotelId(id);
    }
    @GetMapping(path="/{id}")
    public @ResponseBody Hotel getHotelById(@PathVariable(name = "id") Long id) {
        return hotelService.getHotelById(id);
    }
    @PostMapping(path="/addPhoto")
    public ResponseEntity<HotelPhoto> addHotelNewPhoto (@RequestBody HotelPhoto newHotelPhoto) {
        hotelService.addHotelNewPhoto(newHotelPhoto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHotelPhoto);
    }

    @PostMapping(path="/{id}/addPhoto")
    public ResponseEntity<HotelPhoto> addHotelNewPhoto (@RequestParam("img") MultipartFile multipartFile,
                                                                @PathVariable(name = "id") Long id) throws FileSystemException {
        String fileName = SaveFIle.saveFile(multipartFile);
        HotelPhoto newHotelPhoto = new HotelPhoto();
        newHotelPhoto.setPhotoUrl(fileName);
        newHotelPhoto.setHotelId(id);
        hotelService.addHotelNewPhoto(newHotelPhoto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHotelPhoto);
    }
    @DeleteMapping(path="/{id}/deletePhoto/{idPhoto}")
    public ResponseEntity<String> deleteHotelPhoto (@PathVariable(name = "id") Long id,
                                                    @PathVariable(name = "idPhoto") Long idPhoto) {
        hotelService.deleteHotelPhoto(id, idPhoto);
        logger.info("Фото удалено");
        return ResponseEntity.ok().body("успешно");
    }
}
