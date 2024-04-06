package com.keklyndia.russpass.controller;

import com.keklyndia.russpass.entity.Excursion;
import com.keklyndia.russpass.service.ExcursionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/excursion")
@CrossOrigin
public class ExcursionController {
    @Autowired
    private ExcursionService excursionService;

    @PostMapping()
    public ResponseEntity<Excursion> addNewExcursion (@RequestBody Excursion newExcursion) {
        excursionService.saveExcursion(newExcursion);
        return ResponseEntity.status(HttpStatus.CREATED).body(newExcursion);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteExcursion (@PathVariable(name = "id") Long id) {
        excursionService.deleteExcursion(id);
        return ResponseEntity.ok().body("успешно");
    }
    @GetMapping()
    public @ResponseBody Iterable<Excursion> getAllExcursions() {
        return excursionService.getAllExcursions();
    }
    @GetMapping(path="/{id}")
    public @ResponseBody Excursion getExcursionById(@PathVariable(name = "id") Long id) {
        return excursionService.getExcursionById(id);
    }

}
