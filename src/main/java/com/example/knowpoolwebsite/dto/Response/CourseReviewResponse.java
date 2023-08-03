package com.example.knowpoolwebsite.dto.Response;

import com.example.knowpoolwebsite.dto.CourseeResponse;
import com.example.knowpoolwebsite.dto.UserrResponse;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseReviewResponse {
    private Integer reviewId;
    private String review;
    private Integer rating;
    private CourseeResponse course;
    private UserrResponse user;
}
