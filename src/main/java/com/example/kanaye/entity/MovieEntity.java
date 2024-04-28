package com.example.kanaye.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.*;
@Entity
@Table(name = "movie")
@Setter
@Getter
@NoArgsConstructor
public class MovieEntity implements Serializable {

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
    @JsonIgnore
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
    private Set<CommentEntity> comments;


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

}
