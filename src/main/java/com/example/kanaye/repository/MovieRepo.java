package com.example.kanaye.repository;

import com.example.kanaye.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MovieRepo extends JpaRepository<MovieEntity, Long> {
    List<MovieEntity> findFirst2ByOrderByIdDesc();

}
