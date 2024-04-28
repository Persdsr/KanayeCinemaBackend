package com.example.kanaye.models;

import com.example.kanaye.entity.EReview;
import com.example.kanaye.entity.ReviewEntity;
import com.example.kanaye.entity.User;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Review implements Serializable {
    private User author;
    private String title;
    private String text;

    // @Enumerated(EnumType.STRING)
    private EReview review;

    public static Review toModel(ReviewEntity reviewEntity) {
        Review review = new Review();
        review.setReview(reviewEntity.getReview());
        review.setText(reviewEntity.getText());
        review.setAuthor(reviewEntity.getAuthor());
        return review;
    }
}
