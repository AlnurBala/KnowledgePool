package com.example.knowpoolwebsite.dto.Response;

import com.example.knowpoolwebsite.dto.CourseReviewwResponse;
import com.example.knowpoolwebsite.dto.DiscounttResponse;
import com.example.knowpoolwebsite.dto.EnrollmenttResponse;
import com.example.knowpoolwebsite.dto.TransactionnResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Integer userId;
    private String name;
    private String emailAddress;
    private String password;
    private String paymentDetails;
    private List<EnrollmenttResponse> enrollments;
    private List<CourseReviewwResponse> courseReviews;
    private List<TransactionnResponse> transactions;

}
