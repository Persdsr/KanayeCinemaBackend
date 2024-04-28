package com.example.kanaye.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "genre")
@Data
@NoArgsConstructor
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

    public GenreEntity(Long id, String title, String imageURL, Set<MovieEntity> movies) {
        this.id = id;
        this.title = title;
        this.imageURL = imageURL;
        this.movies = movies;
    }

}
