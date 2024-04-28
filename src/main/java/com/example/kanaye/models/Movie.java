package com.example.kanaye.models;

import com.example.kanaye.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.List;

@Data
@NoArgsConstructor
public class Movie implements Serializable {
    private Long id;
    private String title;
    private Float duration;
    private Float fees;
    private String slogan;
    private String description;
    private String movieFileUrl;
    private Set<GenreEntity> genres;
    private String slugUrl;
    private String poster;
    private String verticalPoster;
    private String fullPoster;
    private String trailer;

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

    public static Movie toModel(MovieEntity movieEntity) {
        Movie movie = new Movie();
        movie.setId(movieEntity.getId());
        movie.setTitle(movieEntity.getTitle());
        movie.setMovieFileUrl(movieEntity.getMovieFileUrl());
        movie.setFees(movieEntity.getFees());
        movie.setDescription(movieEntity.getDescription());
        movie.setGenres(movieEntity.getGenres());

        return movie;
    }

    public Movie(Long id, String title, Float duration, Float fees, String slogan, String description, String movieFileUrl, Set<GenreEntity> genres, String slugUrl, String poster, String verticalPoster, String fullPoster, String trailer, Integer yearProduction, String country, Integer budget, Integer ageLimit, List<String> screenshots, List<ReviewEntity> reviews, String author, Date datePremiere, Set<CommentEntity> comments) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.fees = fees;
        this.slogan = slogan;
        this.description = description;
        this.movieFileUrl = movieFileUrl;
        this.genres = genres;
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

