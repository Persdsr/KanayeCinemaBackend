package com.example.kanaye.service;

import com.example.kanaye.entity.GenreEntity;
import com.example.kanaye.entity.MovieEntity;
import com.example.kanaye.entity.User;
import com.example.kanaye.models.MovieWithoutGenres;
import com.example.kanaye.repository.GenreRepo;
import com.example.kanaye.repository.MovieRepo;
import com.example.kanaye.models.Movie;
import com.example.kanaye.repository.UserRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class MovieService {

    private final MovieRepo movieRepo;

    private final StorageService storageService;

    private final GenreRepo genreRepo;

    private final UserRepository userRepo;

    public MovieService(StorageService storageService, MovieRepo movieRepo, GenreRepo genreRepo, UserRepository userRepo) {
        this.storageService = storageService;
        this.movieRepo = movieRepo;
        this.genreRepo = genreRepo;
        this.userRepo = userRepo;
    }

    public List<MovieEntity> getAllMovies() throws InterruptedException {
        return movieRepo.findAll();
    }


    public Movie getMovieById(Long id) {
        Optional<MovieEntity> resMovie = movieRepo.findById(id);

        MovieEntity existsMovie = resMovie.get();

        Movie movie = new Movie(
                existsMovie.getId(),
                existsMovie.getTitle(),
                existsMovie.getDuration(),
                existsMovie.getFees(),
                existsMovie.getSlogan(),
                existsMovie.getDescription(),
                existsMovie.getMovieFileUrl(),
                existsMovie.getGenres(),
                existsMovie.getSlugUrl(),
                existsMovie.getPoster(),
                existsMovie.getVerticalPoster(),
                existsMovie.getFullPoster(),
                existsMovie.getTrailer(),
                existsMovie.getYearProduction(),
                existsMovie.getCountry(),
                existsMovie.getBudget(),
                existsMovie.getAgeLimit(),
                existsMovie.getScreenshots(),
                existsMovie.getReviews(),
                existsMovie.getAuthor(),
                existsMovie.getDatePremiere(),
                existsMovie.getComments()
        );

        return movie;
    }

    @Transactional
    public ResponseEntity updateMovie(Long id,
                                      Movie movie,
                                      MultipartFile movieFile,
                                      MultipartFile moviePoster,
                                      MultipartFile fullPoster,
                                      MultipartFile verticalPoster,
                                      MultipartFile movieTrailer) {
        Optional<MovieEntity> optionMovie = movieRepo.findById(id);

        String nameFile = storageService.store(movieFile);
        String nameVerticalPoster = storageService.store(verticalPoster);
        String namePoster = storageService.store(moviePoster);
        String nameFullPoster = storageService.store(fullPoster);
        String nameTrailer = storageService.store(movieTrailer);

        /*ArrayList<String> fileNames = new ArrayList<>(List.of(nameFile, nameVerticalPoster, namePoster, nameFullPoster, nameTrailer));

        for (String fileName: fileNames) {

        }*/

        String uriFile = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(nameFile)
                .toUriString();

        String uriVerticalPoster = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(nameVerticalPoster)
                .toUriString();

        String uriPoster = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(namePoster)
                .toUriString();

        String uriFullPoster = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(nameFullPoster)
                .toUriString();

        String uriTrailer = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(nameTrailer)
                .toUriString();

        if (optionMovie.isEmpty()) {
            return ResponseEntity.badRequest().body("НЕТ");
        }

        Set<GenreEntity> genreList = movie.getGenres();
        Set<String> genres = new HashSet<>();
        for (GenreEntity genre : genreList) {
            if (!genreRepo.existsByTitle(genre.getTitle())) {
                return ResponseEntity.badRequest().body("НЕТ ТАКОГО ЖАНРА");
            }
            genres.add(genre.getTitle());
        }
        Set<GenreEntity> genreSet = genreRepo.findByTitleIn(genres);

        MovieEntity existMovie = optionMovie.get();
        existMovie.setTitle(movie.getTitle());
        existMovie.setDescription(movie.getDescription());
        existMovie.setDuration(movie.getDuration());
        existMovie.setFees(movie.getFees());
        existMovie.setSlogan(movie.getSlogan());
        existMovie.setGenres(genreSet);
        existMovie.setMovieFileUrl(uriFile);
        existMovie.setPoster(uriPoster);
        existMovie.setTrailer(movie.getTrailer());
        existMovie.setVerticalPoster(uriVerticalPoster);
        existMovie.setFullPoster(uriFullPoster);
        existMovie.setAgeLimit(movie.getAgeLimit());
        existMovie.setBudget(movie.getBudget());
        existMovie.setDatePremiere(movie.getDatePremiere());
        existMovie.setYearProduction(movie.getYearProduction());
        existMovie.setCountry(movie.getCountry());
        existMovie.setTrailer(uriTrailer);

        return ResponseEntity.ok().body(movieRepo.save(existMovie));

    }

    public ResponseEntity createMovie(Movie newMovie,
                                      MultipartFile movieFile,
                                      MultipartFile moviePoster,
                                      MultipartFile verticalPoster,
                                      MultipartFile trailer,
                                      MultipartFile[] screenshots,
                                      MultipartFile fullPoster) {

        String nameFile = storageService.store(movieFile);
        String nameTrailer = storageService.store(trailer);
        String namePoster = storageService.store(moviePoster);
        String nameVerticalPoster = storageService.store(verticalPoster);
        String nameFullPoster = storageService.store(fullPoster);

        ArrayList<String> nameScreenshots = new ArrayList<>();

        for (MultipartFile screenshot: screenshots) {
            nameScreenshots.add(storageService.store(screenshot));
        }


        String uriFile = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(nameFile)
                .toUriString();

        String uriTrailer = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(nameTrailer)
                .toUriString();

        String uriPoster = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(namePoster)
                .toUriString();

        String uriFullPoster = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(nameFullPoster)
                .toUriString();

        String uriVerticalPoster = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(nameVerticalPoster)
                .toUriString();


        ArrayList<String> uriScreenshots = new ArrayList<>();

        for (String screenshotName : nameScreenshots) {
            String uriScreenshot = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(screenshotName)
                    .toUriString();
            uriScreenshots.add(uriScreenshot);
        }

        Set<GenreEntity> genreList = newMovie.getGenres();
        Set<String> genres = new HashSet<>();
        for (GenreEntity genre : genreList) {
            if (!genreRepo.existsByTitle(genre.getTitle())) {
                return ResponseEntity.badRequest().body("Жанра " + genre.getTitle() + " не существует");
            }
            genres.add(genre.getTitle());
        }
        Set<GenreEntity> genreSet = genreRepo.findByTitleIn(genres);


        MovieEntity movie = new MovieEntity(
                newMovie.getId(),
                newMovie.getTitle(),
                newMovie.getDuration(),
                newMovie.getFees(),
                newMovie.getSlogan(),
                newMovie.getDescription(),
                uriFile,
                newMovie.getSlugUrl(),
                uriPoster,
                uriVerticalPoster,
                uriFullPoster,
                uriTrailer,
                newMovie.getYearProduction(),
                newMovie.getCountry(),
                newMovie.getBudget(),
                newMovie.getAgeLimit(),
                uriScreenshots,
                newMovie.getAuthor(),
                newMovie.getDatePremiere(),
                genreSet,
                newMovie.getComments()
        );

        movieRepo.save(movie);

        return ResponseEntity.ok().body(movie);
    }

    public ResponseEntity deleteMovie(Long id) {
        movieRepo.deleteById(id);
        return ResponseEntity.ok().body(id + " удален");
    }

    @Cacheable(value = "movie")
    public List<MovieWithoutGenres> movieByGenreTitle(String genreTitle) {
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<MovieEntity> moviesEntity = movieRepo.findAllByGenresTitle(genreTitle);
        ArrayList<MovieWithoutGenres> movies = new ArrayList<>();
        for (MovieEntity movie: moviesEntity) {
            movies.add(MovieWithoutGenres.toModel(movie));
        }
        return movies;
    }

    public ResponseEntity lastTwo() {
        return ResponseEntity.ok(movieRepo.findFirst2ByOrderByIdDesc());
    }
}
