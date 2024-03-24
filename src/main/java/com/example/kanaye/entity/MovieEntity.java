package com.example.kanaye.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

@Entity
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Float duration;
    private Float fees;
    private String slogan;
    @Column(length = 1000)
    private String description;
    @Column(length = 2048)
    private String movieFileUrl;
    @Column(length = 2048)
    private String slugUrl;
    @Column(length = 2048)
    private String poster;
    @Column(length = 2048)
    private String verticalPoster;
    @Column(length = 2048)
    private String fullPoster;
    @Column(length = 2048)
    private String trailer;
    private Integer yearProduction;
    private String country;
    private Integer budget;
    private Integer ageLimit;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<ReviewEntity> reviews;

    @ElementCollection
    private List<String> screenshots;

    private String author;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date datePremiere;

    @ManyToMany()
    @JoinTable(name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @JsonIgnore
    private Set<GenreEntity> genres;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<CommentEntity> comments = new HashSet<>();


    public MovieEntity(Long id, String title, Float duration, Float fees, String slogan, String description, String movieFileUrl, String slugUrl, String poster, String verticalPoster, String fullPoster, String trailer, Integer yearProduction, String country, Integer budget, Integer ageLimit, List<String> screenshots, String author, Date datePremiere, Set<GenreEntity> genres, Set<CommentEntity> comments) {
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
        this.author = author;
        this.datePremiere = datePremiere;
        this.genres = genres;
        this.comments = comments;
    }



    public Long getId() {
        return id;
    }

    public String getSlugUrl() {
        return slugUrl;
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

    public String getAuthor() {
        return author;
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setSlugUrl(String slugUrl) {
        this.slugUrl = slugUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullPoster() {
        return fullPoster;
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

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }

    public Date getDatePremiere() {
        return datePremiere;
    }

    public void setDatePremiere(Date datePremiere) {
        this.datePremiere = datePremiere;
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

    public MovieEntity() {

    }
}
