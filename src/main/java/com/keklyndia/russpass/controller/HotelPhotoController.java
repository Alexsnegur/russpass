package com.keklyndia.russpass.controller;

import com.keklyndia.russpass.entity.HotelPhoto;
import com.keklyndia.russpass.service.HotelService;
import com.keklyndia.russpass.util.SaveFIle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileSystemException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/hotel-photo")
@CrossOrigin
public class HotelPhotoController {
    private final HotelService hotelService;

    @GetMapping(path = "/{id}")
    public @ResponseBody Iterable<HotelPhoto> getAllPhotoHotel(@PathVariable(name = "id") Long id) {
        return hotelService.getAllPhotoByHotelId(id);
    }
    @PostMapping(path = "/{id}")
    public ResponseEntity<HotelPhoto> addHotelNewPhoto(@RequestParam("img") MultipartFile multipartFile,
                                                       @PathVariable(name = "id") Long id) throws FileSystemException {
        String fileName = SaveFIle.saveFile(multipartFile);
        HotelPhoto newHotelPhoto = new HotelPhoto();
        newHotelPhoto.setPhotoUrl(fileName);
        newHotelPhoto.setHotelId(id);
        hotelService.addHotelNewPhoto(newHotelPhoto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHotelPhoto);
    }

    @DeleteMapping(path = "/{id}/{idPhoto}")
    public ResponseEntity<String> deleteHotelPhoto(@PathVariable(name = "id") Long id,
                                                   @PathVariable(name = "idPhoto") Long idPhoto) {
        hotelService.deleteHotelPhoto(id, idPhoto);
        return ResponseEntity.ok().body("успешно");
    }
}
