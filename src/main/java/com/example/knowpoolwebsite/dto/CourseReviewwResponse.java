package com.example.knowpoolwebsite.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseReviewwResponse {
    private Integer reviewId;
    private String review;
    private BigDecimal rating;
}
