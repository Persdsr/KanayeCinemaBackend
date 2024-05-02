package com.example.kanaye.service;

import com.example.kanaye.entity.MovieEntity;
import com.example.kanaye.entity.ReviewEntity;
import com.example.kanaye.entity.User;
import com.example.kanaye.models.Review;
import com.example.kanaye.models.ReviewRequest;
import com.example.kanaye.repository.MovieRepo;
import com.example.kanaye.repository.ReviewRepo;
import com.example.kanaye.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepo reviewRepo;
    private final MovieRepo movieRepo;
    private final UserRepository userRepository;

    public ReviewService(ReviewRepo reviewRepo, MovieRepo movieRepo, UserRepository userRepository) {
        this.reviewRepo = reviewRepo;
        this.movieRepo = movieRepo;
        this.userRepository = userRepository;
    }

    public ResponseEntity getReviewByMovieId(Long movieId) {
        return ResponseEntity.ok().body("");
    }

    public String deleteMovieById(Long reviewId) {
        reviewRepo.deleteById(reviewId);
        return "OK";
    }

    public ResponseEntity createReviewByMovieId(ReviewRequest reviewRequest) {
        User user = userRepository.findByUsername(reviewRequest.getUsername()).orElse(null);
        MovieEntity movie = movieRepo.findById(reviewRequest.getMovieId()).orElse(null);

        ReviewEntity review = new ReviewEntity();
        review.setMovie(movie);
        review.setReview(reviewRequest.getReview());
        review.setAuthor(user);
        review.setText(reviewRequest.getText());
        review.setTitle(reviewRequest.getTitle());

        reviewRepo.save(review);
        return ResponseEntity.ok().body(review);
    }
}
