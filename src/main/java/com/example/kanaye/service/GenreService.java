package com.example.kanaye.service;

import com.example.kanaye.entity.GenreEntity;
import com.example.kanaye.repository.GenreRepo;
import com.example.kanaye.models.Genre;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepo genreRepo;
    private final StorageService storageService;

    public GenreService(GenreRepo genreRepo, StorageService storageService) {
        this.genreRepo = genreRepo;
        this.storageService = storageService;
    }

    public ResponseEntity getAllGenres() {
        return ResponseEntity.ok().body(genreRepo.findAll());
    }

    public ResponseEntity getGenreDetail(String slugUrl) {
        return ResponseEntity.ok().body(genreRepo.findGenreBySlugUrlIgnoreCase(slugUrl));
    }

    public ResponseEntity updateGenre(Long id, Genre genre) {
        Optional<GenreEntity> optionalGenre = genreRepo.findById(id);
        GenreEntity existGenre = optionalGenre.get();

        existGenre.setTitle(genre.getTitle());
        existGenre.setImageURL(genre.getImageURL());
        existGenre.setSlugUrl(genre.getSlugUrl());

        return ResponseEntity.ok().body(genreRepo.save(existGenre));
    }

    public ResponseEntity createGenre(GenreEntity genre, MultipartFile file) {
        String nameFile= storageService.store(file);

        String uriFile = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(nameFile)
                .toUriString();

        genre.setImageURL(uriFile);

        return ResponseEntity.ok().body(genreRepo.save(genre));
    }

    public ResponseEntity deleteGenre(Long id) {
        genreRepo.deleteById(id);
        return ResponseEntity.ok().body(id + " удален");
    }
}
