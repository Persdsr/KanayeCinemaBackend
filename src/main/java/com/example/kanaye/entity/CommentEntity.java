package com.example.kanaye.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import com.example.kanaye.entity.User;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

@Entity
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User author;

    @Column(length = 1000)
    private String message;

    @ManyToOne()
    @JoinColumn(name = "movie_id")
    @JsonIgnore
    private MovieEntity movie;



}
