package com.keklyndia.russpass.controller;

import com.keklyndia.russpass.entity.ExcursionPhoto;
import com.keklyndia.russpass.service.ExcursionService;
import com.keklyndia.russpass.util.SaveFIle;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileSystemException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/excursion-photo")
public class ExcursionPhotoController {
    @Autowired
    private ExcursionService excursionService;
    @GetMapping(path="/{id}")
    public @ResponseBody Iterable<ExcursionPhoto> getAllPhotoExcursion(@PathVariable(name = "id") Long id) {
        return excursionService.getAllPhotoByExcursionId(id);
    }
    @PostMapping(path="/{id}")
    public ResponseEntity<ExcursionPhoto> addExcursionNewPhoto (@RequestParam("img") MultipartFile multipartFile,
                                                                @PathVariable(name = "id") Long id) throws FileSystemException {
        String fileName = SaveFIle.saveFile(multipartFile);
        ExcursionPhoto newExcursionPhoto = new ExcursionPhoto();
        newExcursionPhoto.setPhotoUrl(fileName);
        newExcursionPhoto.setExcursionId(id);
        excursionService.addExcursionNewPhoto(newExcursionPhoto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newExcursionPhoto);
    }
    @DeleteMapping(path="/{id}/{idPhoto}")
    public ResponseEntity<String> deleteExcursionPhoto (@PathVariable(name = "id") Long id,
                                                        @PathVariable(name = "idPhoto") Long idPhoto) {
        excursionService.deleteExcursionPhoto(id, idPhoto);
        return ResponseEntity.ok().body("успешно");
    }

}
