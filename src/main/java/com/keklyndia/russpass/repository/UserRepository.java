package com.keklyndia.russpass.repository;

import com.keklyndia.russpass.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
