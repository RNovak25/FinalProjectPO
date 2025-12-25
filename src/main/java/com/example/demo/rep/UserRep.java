package com.example.demo.rep;

import com.example.demo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);
}