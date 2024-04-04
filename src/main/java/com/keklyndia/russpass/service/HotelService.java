package com.keklyndia.russpass.service;

import com.keklyndia.russpass.entity.ExcursionPhoto;
import com.keklyndia.russpass.entity.Hotel;
import com.keklyndia.russpass.entity.HotelPhoto;
import com.keklyndia.russpass.repository.HotelPhotoRepository;
import com.keklyndia.russpass.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelPhotoRepository hotelPhotoRepository;
    public List<HotelPhoto> getAllPhotoByHotelId(Long id) {
        return hotelPhotoRepository.findByHotelId(id);
    }
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public Hotel saveHotel(Hotel excursion) {
        return hotelRepository.save(excursion);
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
    public void addHotelNewPhoto (HotelPhoto newHotelPhoto) {
        hotelPhotoRepository.save(newHotelPhoto);
    }
    public void deleteHotelPhoto (Long id, Long idPhoto) {
        hotelPhotoRepository.deletePhoto(id, idPhoto);
    }
}
