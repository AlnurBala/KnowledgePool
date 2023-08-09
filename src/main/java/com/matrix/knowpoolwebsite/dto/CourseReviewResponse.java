package com.matrix.knowpoolwebsite.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseReviewResponse {
    private Integer reviewId;
    private String review;
    private BigDecimal rating;
}
