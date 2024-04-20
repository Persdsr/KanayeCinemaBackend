package com.example.kanaye.controller;

import com.example.kanaye.entity.GenreEntity;
import com.example.kanaye.service.GenreService;
import com.example.kanaye.models.Genre;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/api/genre")
    public ResponseEntity getAllGenre() {
        return genreService.getAllGenres();
    }

    @GetMapping("/api/genre123/{genre}")
    public ResponseEntity getGenreDetail(@PathVariable("genre") String genreSlugUrl) {
        return genreService.getGenreDetail(genreSlugUrl);
    }

    @PutMapping("/api/genre-update/{id}")
    public ResponseEntity updateGenre(@PathVariable("id") Long id, @RequestBody Genre genre) {
        return genreService.updateGenre(id, genre);
    }

    @PostMapping("/api/genre/add_genre")
    public ResponseEntity createGenre(@RequestPart("genre") GenreEntity genre, @RequestPart("imageUrl") MultipartFile image) {
        return ResponseEntity.ok().body(genreService.createGenre(genre, image));
    }

    @DeleteMapping("/api/delete_genre/{id}")
    public ResponseEntity deleteGenre(@PathVariable("id") Long id) {
        return genreService.deleteGenre(id);
    }
}
