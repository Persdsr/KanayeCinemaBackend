package com.example.kanaye.models;

import com.example.kanaye.entity.EReview;
import com.example.kanaye.entity.MovieEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
public class ReviewRequest implements Serializable {
    private String username;
    private EReview review;
    private String text;
    private String title;
    private Long movieId;

    public ReviewRequest(String username, EReview review, String text, String title, Long movieId) {
        this.username = username;
        this.review = review;
        this.text = text;
        this.title = title;
        this.movieId = movieId;
    }
}
