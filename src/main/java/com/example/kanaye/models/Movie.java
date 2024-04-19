package com.example.kanaye.models;

import com.example.kanaye.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.List;

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

    public Movie() {
    }

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

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public String getAuthor() {
        return author;
    }

    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

    public List<String> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(List<String> screenshots) {
        this.screenshots = screenshots;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVerticalPoster() {
        return verticalPoster;
    }

    public void setVerticalPoster(String verticalPoster) {
        this.verticalPoster = verticalPoster;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }

    public String getSlugUrl() {
        return slugUrl;
    }

    public void setSlugUrl(String slugUrl) {
        this.slugUrl = slugUrl;
    }

    public String getPoster() {
        return poster;
    }

    public String getFullPoster() {
        return fullPoster;
    }

    public Integer getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(Integer yearProduction) {
        this.yearProduction = yearProduction;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Date getDatePremiere() {
        return datePremiere;
    }

    public void setDatePremiere(Date datePremiere) {
        this.datePremiere = datePremiere;
    }

    public void setFullPoster(String fullPoster) {
        this.fullPoster = fullPoster;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public Float getFees() {
        return fees;
    }

    public void setFees(Float fees) {
        this.fees = fees;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMovieFileUrl() {
        return movieFileUrl;
    }

    public void setMovieFileUrl(String movieFileUrl) {
        this.movieFileUrl = movieFileUrl;
    }

    public Set<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(Set<GenreEntity> genres) {
        this.genres = genres;
    }


}

