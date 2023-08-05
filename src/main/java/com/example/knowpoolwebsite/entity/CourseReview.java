package com.example.knowpoolwebsite.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "course_reviews", schema = "project")
public class CourseReview {
    @Id
    @Column(name = "review_id")
    private Integer reviewId;
    @Column(name = "review")
    private String review;
    @Column(name = "rating")
    private BigDecimal rating;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
