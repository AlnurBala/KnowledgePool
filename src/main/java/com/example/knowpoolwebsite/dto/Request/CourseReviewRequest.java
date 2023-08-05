package com.example.knowpoolwebsite.dto.Request;

import com.example.knowpoolwebsite.annotation.ValidRating;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
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
