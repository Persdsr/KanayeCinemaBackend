package com.example.kanaye.models;

import com.example.kanaye.entity.GenreEntity;


import java.util.List;
import java.util.stream.Collectors;

public class Genre {
    private Long id;
    private String title;
    private List<Movie> movies;
    private String imageURL;
    private String slugUrl;

    public static Genre toModel(GenreEntity genreEntity) {
        Genre genre = new Genre();
        genre.setId(genreEntity.getId());
        genre.setTitle(genreEntity.getTitle());
        genre.setImageURL(genreEntity.getImageURL());
        genre.setMovies(genreEntity.getMovies().stream().map(Movie::toModel).collect(Collectors.toList()));

        return genre;
    }

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