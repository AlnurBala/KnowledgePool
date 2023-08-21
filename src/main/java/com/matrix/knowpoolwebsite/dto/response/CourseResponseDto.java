package com.matrix.knowpoolwebsite.dto.response;

import com.matrix.knowpoolwebsite.dto.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseResponseDto {
    private Integer courseId;
    private String title;
    private String description;
    private Integer duration;
    private Integer price;
    private String status;
    private Date uploadDate;
    private List<EnrollmentResponse> enrollments;
    private List<CourseReviewResponse> courseReviews;
    private List<TransactionResponse> transactions;
    private List<DiscountResponse> discounts;
    private CategoryResponse category;
}
