package com.example.kanaye.repository;

import com.example.kanaye.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GenreRepo extends JpaRepository<GenreEntity, Long> {
    Boolean existsByTitle(String title);
    Set<GenreEntity> findByTitleIn(Set<String> titles);
    GenreEntity findBySlugUrl(String slugUrl);
    GenreEntity findGenreBySlugUrlIgnoreCase(String slugUrl);

}
