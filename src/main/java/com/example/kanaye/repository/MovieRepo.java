package com.example.kanaye.repository;

import com.example.kanaye.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<MovieEntity, Long> {
    List<MovieEntity> findFirst2ByOrderByIdDesc();
    List<MovieEntity> findAllByGenresTitle(String genreTitle);
}
