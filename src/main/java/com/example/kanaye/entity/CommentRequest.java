package com.example.kanaye.entity;

import java.io.Serializable;

public class CommentRequest implements Serializable {
    private Long movieId;
    private String message;
    private String username;

    public CommentRequest() {
    }

    public CommentRequest(Long movieId, String message, String username) {
        this.movieId = movieId;
        this.message = message;
        this.username = username;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
