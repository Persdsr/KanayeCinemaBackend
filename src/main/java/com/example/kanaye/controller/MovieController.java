package com.example.kanaye.controller;

import com.example.kanaye.service.MovieService;
import com.example.kanaye.service.StorageService;
import com.example.kanaye.models.Movie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.io.IOException;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    private final MovieService movieService;
    private StorageService storageService;

    public MovieController(MovieService movieService, StorageService storageService) {
        this.storageService = storageService;
        this.movieService = movieService;
    }

    @GetMapping("/api/movie")
    public ResponseEntity getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/api/movie/{id}")
    public ResponseEntity getMovieDetail(@PathVariable("id") Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping(value = "/api/add_movie", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity createMovie(@RequestPart("MovieDetail") Movie new_movie,
                                      @RequestPart("MainMovieFile") MultipartFile movieFile,
                                      @RequestPart("Poster") MultipartFile moviePoster,
                                      @RequestPart("VerticalPoster") MultipartFile verticalPoster,
                                      @RequestPart("Trailer") MultipartFile trailer,
                                      @RequestPart("Screenshots") MultipartFile[] screenshots,
                                      @RequestPart("FullPoster") MultipartFile fullPoster) {
        return movieService.createMovie(new_movie, movieFile, moviePoster, verticalPoster, trailer, screenshots, fullPoster);
    }

    @PutMapping("/api/movie-update/{id}")
    public ResponseEntity updateMovie(@PathVariable("id") Long id,
                                      @RequestPart("movie") Movie movie,
                                      @RequestPart("movieFile") MultipartFile movieFile,
                                      @RequestPart("moviePoster") MultipartFile moviePoster,
                                      @RequestPart("movieTrailer") MultipartFile movieTrailer,
                                      @RequestPart("movieVerticalPoster") MultipartFile verticalPoster,
                                      @RequestPart("fullPoster") MultipartFile fullPoster) {
        return movieService.updateMovie(id, movie, movieFile, moviePoster, fullPoster, verticalPoster, movieTrailer);
    }

    @DeleteMapping("/api/delete_movie/{id}")
    public ResponseEntity deleteMovie(@PathVariable("id") Long id) {
        return movieService.deleteMovie(id);
    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        Resource resource = storageService.loadAsResource(filename);
        System.out.println("RABOTAEM");
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    /*@PostMapping("/upload-multiple-files")
    public List<FileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.stream(files)
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }*/

    @GetMapping("/api/lasttwo")
    public ResponseEntity lastTwo() {
        return movieService.lastTwo();
    }

}

