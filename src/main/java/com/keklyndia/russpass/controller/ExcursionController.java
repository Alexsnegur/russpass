package com.keklyndia.russpass.controller;

import com.keklyndia.russpass.entity.Excursion;
import com.keklyndia.russpass.entity.ExcursionPhoto;
import com.keklyndia.russpass.entity.Hotel;
import com.keklyndia.russpass.entity.HotelPhoto;
import com.keklyndia.russpass.service.ExcursionService;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystemException;

@Controller
@RequestMapping(path="/excursion")
public class ExcursionController {
    Logger logger = LoggerFactory.getLogger(ExcursionController.class);
    @Autowired
    private ExcursionService excursionService;

    @PostMapping(path="/add")
    public ResponseEntity<Excursion> addNewExcursion (@RequestBody Excursion newExcursion) {
        excursionService.saveExcursion(newExcursion);
        logger.info("Добавлена экскурсия");
        return ResponseEntity.status(HttpStatus.CREATED).body(newExcursion);
    }

    @DeleteMapping(path="/{id}/delete")
    public ResponseEntity<String> deleteExcursion (@PathVariable(name = "id") Long id) {
        excursionService.deleteExcursion(id);
        logger.info("Экскурсия удалена");
        return ResponseEntity.ok().body("успешно");
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Excursion> getAllExcursions() {
        return excursionService.getAllExcursions();
    }
    @GetMapping(path="/{id}/photos")
    public @ResponseBody Iterable<ExcursionPhoto> getAllPhotoExcursion(@PathVariable(name = "id") Long id) {
        return excursionService.getAllPhotoByExcursionId(id);
    }
    @GetMapping(path="/{id}")
    public @ResponseBody Excursion getExcursionById(@PathVariable(name = "id") Long id) {
        return excursionService.getExcursionById(id);
    }
    @PostMapping(path="/{id}/addPhoto")
    public ResponseEntity<ExcursionPhoto> addExcursionNewPhoto (@RequestParam("img") MultipartFile multipartFile,
                                                                @PathVariable(name = "id") Long id) throws FileSystemException {
        String fileName = SaveFIle.saveFile(multipartFile);
        ExcursionPhoto newExcursionPhoto = new ExcursionPhoto();
        newExcursionPhoto.setPhotoUrl(fileName);
        newExcursionPhoto.setExcursionId(id);
        excursionService.addExcursionNewPhoto(newExcursionPhoto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newExcursionPhoto);
    }
    @DeleteMapping(path="/{id}/deletePhoto/{idPhoto}")
    public ResponseEntity<String> deleteExcursionPhoto (@PathVariable(name = "id") Long id,
                                                    @PathVariable(name = "idPhoto") Long idPhoto) {
        excursionService.deleteExcursionPhoto(id, idPhoto);
        logger.info("Фото удалено");
        return ResponseEntity.ok().body("успешно");
    }

}
