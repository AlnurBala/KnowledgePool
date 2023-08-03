package com.example.knowpoolwebsite.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseReviewwResponse {
    private Integer reviewId;
    private String review;
    private Integer rating;
}
