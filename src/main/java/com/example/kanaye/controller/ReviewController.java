package com.example.kanaye.controller;

import com.example.kanaye.entity.ReviewEntity;
import com.example.kanaye.models.ReviewRequest;
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

    @PostMapping("/api/send_review")
    private ResponseEntity createReview(@RequestBody ReviewRequest review) {
        return ResponseEntity.ok().body(reviewService.createReviewByMovieId(review));
    }

    @DeleteMapping("/api/review/{review_id}")
    private ResponseEntity deleteReview(@PathVariable("review_id") Long movie_id) {
        return ResponseEntity.ok(reviewService.deleteMovieById(movie_id));
    }
}
