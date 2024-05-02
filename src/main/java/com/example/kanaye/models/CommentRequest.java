package com.example.kanaye.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
public class CommentRequest implements Serializable {
    private Long movieId;
    private String message;
    private String username;


    public CommentRequest(Long movieId, String message, String username) {
        this.movieId = movieId;
        this.message = message;
        this.username = username;
    }
}
