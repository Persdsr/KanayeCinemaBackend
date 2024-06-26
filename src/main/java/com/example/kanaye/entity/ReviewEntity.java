package com.example.kanaye.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "review")
@NoArgsConstructor
@Setter
@Getter
public class ReviewEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    private User author;

    @Enumerated(EnumType.STRING)
    private EReview review;
    private String text;
    private String title;

    @ManyToOne()
    @JoinColumn(name = "movie_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private MovieEntity movie;

    public ReviewEntity(User author, EReview review, String text, String title, MovieEntity movie) {
        this.author = author;
        this.review = review;
        this.text = text;
        this.title = title;
        this.movie = movie;
    }
}
