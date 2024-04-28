package com.example.kanaye.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.kanaye.entity.User;

import java.io.Serializable;
import java.util.Optional;

@Entity
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Data
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
