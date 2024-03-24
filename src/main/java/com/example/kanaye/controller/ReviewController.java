package com.example.kanaye.controller;

import com.example.kanaye.entity.ReviewEntity;
import com.example.kanaye.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/api/review/{movie_id}")
    private ResponseEntity getReviewByMovie(@PathVariable("movie_id") Long movie_id) {
        return reviewService.getReviewByMovieId(movie_id);
    }

    @PostMapping("/api/send_review/{movie_id}")
    private ResponseEntity createReview(@PathVariable Long movie_id, @RequestPart("review") ReviewEntity review, @RequestPart("author") String author) {
        return reviewService.createReviewByMovieId(movie_id, review, author);
    }
}
