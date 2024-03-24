package com.example.kanaye.controller;

import com.example.kanaye.entity.CommentEntity;
import com.example.kanaye.entity.CommentRequest;
import com.example.kanaye.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add_comment")
    public ResponseEntity createComment(@RequestBody CommentRequest comment) {
        return ResponseEntity.ok().body(commentService.addComment(comment));
    }

    @GetMapping("/comments")
    public ResponseEntity allComments() {
        return ResponseEntity.ok().body(commentService.getAllComments());
    }
}
