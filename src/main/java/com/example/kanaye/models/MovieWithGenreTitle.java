package com.example.kanaye.models;

import com.example.kanaye.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class MovieWithGenreTitle implements Serializable {
    private Long id;
    private String title;
    private Float duration;
    private Float fees;
    private String slogan;
    private String description;
    private String movieFileUrl;
    private String slugUrl;
    private String poster;
    private String verticalPoster;
    private String fullPoster;
    private String trailer;
    private Set<String> genres;

    private Integer yearProduction;
    private String country;
    private Integer budget;
    private Integer ageLimit;
    @ElementCollection
    private List<String> screenshots;

    private List<ReviewEntity> reviews;

    private String author;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date datePremiere;

    private Set<CommentEntity> comments;

    public static MovieWithGenreTitle toModel(MovieEntity movieEntity) {
        MovieWithGenreTitle movie = new MovieWithGenreTitle();
        movie.setId(movieEntity.getId());
        movie.setTitle(movieEntity.getTitle());
        movie.setMovieFileUrl(movieEntity.getMovieFileUrl());
        movie.setFees(movieEntity.getFees());
        movie.setDescription(movieEntity.getDescription());
        movie.setAuthor(movieEntity.getAuthor());
        movie.setComments(movieEntity.getComments());
        movie.setDuration(movieEntity.getDuration());
        movie.setPoster(movieEntity.getPoster());
        movie.setVerticalPoster(movieEntity.getVerticalPoster());
        movie.setBudget(movieEntity.getBudget());
        movie.setAgeLimit(movieEntity.getAgeLimit());
        movie.setYearProduction(movieEntity.getYearProduction());
        movie.setSlogan(movieEntity.getSlogan());
        movie.setCountry(movieEntity.getCountry());
        movie.setFullPoster(movieEntity.getFullPoster());
        movie.setPoster(movieEntity.getPoster());
        movie.setDescription(movieEntity.getDescription());
        movie.setTrailer(movieEntity.getTrailer());
        movie.setSlugUrl(movieEntity.getSlugUrl());
        movie.setReviews(movieEntity.getReviews());
        movie.setDatePremiere(movieEntity.getDatePremiere());
        movie.setScreenshots(movieEntity.getScreenshots());

        Set<String> genres = new HashSet<>();
        for (GenreEntity genreEntity: movieEntity.getGenres()) {
            genres.add(genreEntity.getTitle());
        }
        movie.setGenres(genres);

        return movie;
    }

    public MovieWithGenreTitle(Long id, String title, Float duration, Float fees, String slogan, String description, String movieFileUrl, String slugUrl, String poster, String verticalPoster, String fullPoster, String trailer, Integer yearProduction, String country, Integer budget, Integer ageLimit, List<String> screenshots, List<ReviewEntity> reviews, String author, Date datePremiere, Set<CommentEntity> comments) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.fees = fees;
        this.slogan = slogan;
        this.description = description;
        this.movieFileUrl = movieFileUrl;
        this.slugUrl = slugUrl;
        this.poster = poster;
        this.verticalPoster = verticalPoster;
        this.fullPoster = fullPoster;
        this.trailer = trailer;
        this.yearProduction = yearProduction;
        this.country = country;
        this.budget = budget;
        this.ageLimit = ageLimit;
        this.screenshots = screenshots;
        this.reviews = reviews;
        this.author = author;
        this.datePremiere = datePremiere;
        this.comments = comments;
    }

}

