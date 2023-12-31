package com.matrix.knowpoolwebsite.controller;

import com.matrix.knowpoolwebsite.annotation.ValidRating;
import com.matrix.knowpoolwebsite.dto.request.CourseReviewRequest;
import com.matrix.knowpoolwebsite.dto.response.CourseReviewResponseDto;
import com.matrix.knowpoolwebsite.service.CourseReviewService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course_review")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
@Tag(name = "Course Review", description = "Course Review Management APIs")
public class CourseReviewController {
    private final CourseReviewService courseReviewService;

    @GetMapping
    public List<CourseReviewResponseDto> getAllCourseReviews() {
        return courseReviewService.getAllCourseReviews();
    }

    @PostMapping
    public CourseReviewResponseDto createCourseReview(@RequestBody @ValidRating CourseReviewRequest courseReviewRequest) {
        return courseReviewService.createCourseReview(courseReviewRequest);
    }

    @PutMapping("/{id}")
    public CourseReviewResponseDto updateCourseReview(@PathVariable Integer id, @RequestBody CourseReviewRequest courseReviewRequest) {
        return courseReviewService.updateCourseReview(id, courseReviewRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourseReviewById(@PathVariable Integer id) {
        courseReviewService.deleteCourseReview(id);
    }
}
