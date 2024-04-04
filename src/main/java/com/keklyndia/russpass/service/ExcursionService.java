package com.keklyndia.russpass.service;

import com.keklyndia.russpass.entity.Excursion;
import com.keklyndia.russpass.entity.ExcursionPhoto;
import com.keklyndia.russpass.repository.ExcursionPhotoRepository;
import com.keklyndia.russpass.repository.ExcursionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ExcursionService {

    @Autowired
    private ExcursionRepository excursionRepository;
    @Autowired
    private ExcursionPhotoRepository excursionPhotoRepository;

    public List<ExcursionPhoto> getAllPhotoByExcursionId(Long id) {
        return excursionPhotoRepository.findByExcursionId(id);
    }
    public List<Excursion> getAllExcursions() {
        return excursionRepository.findAll();
    }

    public Excursion getExcursionById(Long id) {
        return excursionRepository.findById(id).orElse(null);
    }

    public Excursion saveExcursion(Excursion excursion) {
        return excursionRepository.save(excursion);
    }

    public void deleteExcursion(Long id) {
        excursionRepository.deleteById(id);
    }
    public void addExcursionNewPhoto (ExcursionPhoto newExcursionPhoto) {
        excursionPhotoRepository.save(newExcursionPhoto);
    }
    public void deleteExcursionPhoto (Long id, Long idPhoto) {
        excursionPhotoRepository.deletePhoto(id, idPhoto);
    }
}
