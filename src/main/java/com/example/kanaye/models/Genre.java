package com.example.kanaye.models;

import com.example.kanaye.entity.GenreEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
public class Genre implements Serializable {
    private Long id;
    private String title;
    private List<Movie> movies;
    private String imageURL;
    private String slugUrl;

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

    public Genre(String title, String imageURL, String slugUrl) {
        this.title = title;
        this.imageURL = imageURL;
        this.slugUrl = slugUrl;
    }
}