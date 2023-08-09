package com.matrix.knowpoolwebsite.dto.request;

import com.matrix.knowpoolwebsite.annotation.ValidRating;
import lombok.*;

import java.math.BigDecimal;

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
    @ValidRating
    private BigDecimal rating;
}
