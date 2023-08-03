package com.example.knowpoolwebsite.dto.Request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseReviewRequest {
    private Integer reviewId;
    private Integer userId;
    private Integer courseId;
    private String review;
    private Integer rating;
}
