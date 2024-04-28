package com.example.kanaye.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
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
