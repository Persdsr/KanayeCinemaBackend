package com.example.kanaye.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "review")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    private User author;

    @Enumerated(EnumType.STRING)
    private EReview review;
    private String text;
    private String title;

    @ManyToOne()
    @JoinColumn(name = "movie_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private MovieEntity movie;

}
