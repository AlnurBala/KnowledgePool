package com.matrix.knowpoolwebsite.dto.response;

import com.matrix.knowpoolwebsite.dto.CourseReviewResponse;
import com.matrix.knowpoolwebsite.dto.EnrollmentResponse;
import com.matrix.knowpoolwebsite.dto.TransactionResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String paymentDetails;
    private String role;
    private List<EnrollmentResponse> enrollments;
    private List<CourseReviewResponse> courseReviews;
    private List<TransactionResponse> transactions;

}
