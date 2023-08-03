package com.example.knowpoolwebsite.service;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Request.CourseReviewRequest;
import com.example.knowpoolwebsite.dto.Response.CourseResponse;
import com.example.knowpoolwebsite.dto.Response.CourseReviewResponse;

import java.util.List;

public interface CourseReviewService {
    List<CourseReviewResponse> getAllCourseReviews();

    CourseReviewResponse createCourseReview(CourseReviewRequest courseReviewRequest);
    CourseReviewResponse updateCourseReview(Integer id, CourseReviewRequest courseReviewRequest);

    void deleteCourseReview(Integer id);
}
