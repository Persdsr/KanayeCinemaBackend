package com.example.kanaye.service;

import com.example.kanaye.entity.CommentEntity;
import com.example.kanaye.models.CommentRequest;
import com.example.kanaye.entity.MovieEntity;
import com.example.kanaye.entity.User;
import com.example.kanaye.repository.CommentRepo;
import com.example.kanaye.repository.MovieRepo;
import com.example.kanaye.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepo commentRepo;
    private final MovieRepo movieRepo;
    private final UserRepository userRepo;

    public CommentService(CommentRepo commentRepo, MovieRepo movieRepo, UserRepository userRepo) {
        this.commentRepo = commentRepo;
        this.movieRepo = movieRepo;
        this.userRepo = userRepo;
    }

    public ResponseEntity addComment(CommentRequest requestComment) {
        User user = userRepo.findByUsername(requestComment.getUsername()).orElse(null);
        MovieEntity movie = movieRepo.findById(requestComment.getMovieId()).orElse(null);

        CommentEntity comment = new CommentEntity();
        comment.setMovie(movie);
        comment.setMessage(requestComment.getMessage());
        comment.setAuthor(user);

        commentRepo.save(comment);

        return ResponseEntity.ok(comment);
    }

    public ResponseEntity getAllComments() {

        return ResponseEntity.ok().body(commentRepo.findAllByOrderByIdAsc());
    }
}
