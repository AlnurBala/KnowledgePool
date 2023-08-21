package com.matrix.knowpoolwebsite.service;

import com.matrix.knowpoolwebsite.dto.request.CourseReviewRequest;
import com.matrix.knowpoolwebsite.dto.response.CourseReviewResponseDto;

import java.util.List;

public interface CourseReviewService {
    List<CourseReviewResponseDto> getAllCourseReviews();

    CourseReviewResponseDto createCourseReview(CourseReviewRequest courseReviewRequest);

    CourseReviewResponseDto updateCourseReview(Integer id, CourseReviewRequest courseReviewRequest);

    void deleteCourseReview(Integer id);
}
