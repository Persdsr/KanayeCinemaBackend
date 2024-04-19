package com.example.kanaye.models;

import com.example.kanaye.entity.GenreEntity;


import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class Genre implements Serializable {
    private Long id;
    private String title;
    private List<Movie> movies;
    private String imageURL;
    private String slugUrl;



    public Genre() {
    }

    public Genre(Long id, String title, List<Movie> movies, String imageURL, String slugUrl) {
        this.id = id;
        this.title = title;
        this.movies = movies;
        this.imageURL = imageURL;
        this.slugUrl = slugUrl;
    }

    public Genre(String title, List<Movie> movies, String imageURL, String slugUrl) {
        this.title = title;
        this.movies = movies;
        this.imageURL = imageURL;
        this.slugUrl = slugUrl;
    }

    public String getSlugUrl() {
        return slugUrl;
    }

    public Genre(String title, String imageURL, String slugUrl) {
        this.title = title;
        this.imageURL = imageURL;
        this.slugUrl = slugUrl;
    }

    public void setSlugUrl(String slugUrl) {
        this.slugUrl = slugUrl;
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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}