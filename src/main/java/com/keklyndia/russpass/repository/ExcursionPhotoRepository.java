package com.keklyndia.russpass.repository;

import com.keklyndia.russpass.entity.ExcursionPhoto;
import com.keklyndia.russpass.entity.Hotel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExcursionPhotoRepository extends JpaRepository<ExcursionPhoto, Long> {
    List<ExcursionPhoto> findByExcursionId(@Param("id") Long id);
    @Modifying
    @Transactional
    @Query("delete from ExcursionPhoto f where f.photoId=:idPhoto and f.excursionId=:id")
    void deletePhoto(@Param("id") Long id,
                     @Param("idPhoto") Long idPhoto);
}
