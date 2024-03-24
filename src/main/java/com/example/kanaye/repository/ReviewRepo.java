package com.example.kanaye.repository;

import com.example.kanaye.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<ReviewEntity, Long> {

}
