package com.example.knowpoolwebsite.dto.Response;

import com.example.knowpoolwebsite.dto.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseResponse {
    private Integer courseId;
    private String title;
    private String description;
    private Integer duration;
    private Integer price;
    private String status;
    private List<EnrollmenttResponse> enrollments;
    private List<CourseReviewwResponse>courseReviews;
    private List<TransactionnResponse>transactions;
    private List<DiscounttResponse> discounts;
    private CategoryyResponse category;
}
