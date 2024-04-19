package com.example.kanaye.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "genre")
public class GenreEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "image_url")
    private String imageURL;

    private String slugUrl;

    @ManyToMany(mappedBy = "genres")
    private Set<MovieEntity> movies;

    public GenreEntity(String title) {
        this.title = title;
    }

    public GenreEntity() {
    }

    public GenreEntity(Long id, String title, String imageURL, Set<MovieEntity> movies) {
        this.id = id;
        this.title = title;
        this.imageURL = imageURL;
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlugUrl() {
        return slugUrl;
    }

    public void setSlugUrl(String slugUrl) {
        this.slugUrl = slugUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Set<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieEntity> movies) {
        this.movies = movies;
    }
}
