package com.keklyndia.russpass.repository;

import com.keklyndia.russpass.entity.HotelPhoto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelPhotoRepository extends JpaRepository<HotelPhoto, Long> {
    List<HotelPhoto> findByHotelId(@Param("id") Long id);
    @Modifying
    @Transactional
    @Query("delete from HotelPhoto f where f.photoId=:idPhoto and f.hotelId=:id")
    void deletePhoto(@Param("id") Long id,
                              @Param("idPhoto") Long idPhoto);
}
