package com.matrix.knowpoolwebsite.dto.response;

import com.matrix.knowpoolwebsite.dto.CourseResponse;
import com.matrix.knowpoolwebsite.dto.UserResponse;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseReviewResponseDto {
    private Integer reviewId;
    private String review;
    private BigDecimal rating;
    private CourseResponse course;
    private UserResponse user;
}
