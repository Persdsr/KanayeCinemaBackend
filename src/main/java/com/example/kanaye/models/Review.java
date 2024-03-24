package com.example.kanaye.models;

import com.example.kanaye.entity.EReview;
import com.example.kanaye.entity.ReviewEntity;
import com.example.kanaye.entity.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Review {
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
