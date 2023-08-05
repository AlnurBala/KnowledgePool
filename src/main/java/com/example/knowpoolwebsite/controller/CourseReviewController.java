package com.example.knowpoolwebsite.controller;

import com.example.knowpoolwebsite.annotation.ValidRating;
import com.example.knowpoolwebsite.dto.Request.CourseReviewRequest;
import com.example.knowpoolwebsite.dto.Response.CourseReviewResponse;
import com.example.knowpoolwebsite.service.CourseReviewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course_review")
@RequiredArgsConstructor
@Tag(name = "Course Review",description = "Course Review Management APIs")
public class CourseReviewController {
    private final CourseReviewService courseReviewService;

    @GetMapping
    public List<CourseReviewResponse> getAllCourseReviews() {
        return courseReviewService.getAllCourseReviews();
    }

    @PostMapping
    public CourseReviewResponse createCourseReview(@RequestBody @ValidRating CourseReviewRequest courseReviewRequest) {
        return courseReviewService.createCourseReview(courseReviewRequest);
    }
    @PutMapping("/{id}")
    public CourseReviewResponse updateCourseReview(@PathVariable Integer id, @RequestBody CourseReviewRequest courseReviewRequest) {
        return courseReviewService.updateCourseReview(id, courseReviewRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourseReviewById(@PathVariable Integer id) {
        courseReviewService.deleteCourseReview(id);
    }
}
