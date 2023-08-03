package com.example.knowpoolwebsite.service.impl;

import com.example.knowpoolwebsite.dto.Request.CourseReviewRequest;
import com.example.knowpoolwebsite.dto.Response.CourseReviewResponse;
import com.example.knowpoolwebsite.entity.CourseReview;
import com.example.knowpoolwebsite.mapper.CourseReviewMapper;
import com.example.knowpoolwebsite.repository.CourseReviewRepository;
import com.example.knowpoolwebsite.service.CourseReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseReviewServiceImpl implements CourseReviewService {
    private final CourseReviewRepository courseReviewRepository;
    private final CourseReviewMapper courseReviewMapper;

    @Override
    public List<CourseReviewResponse> getAllCourseReviews() {
        var courseReviewEntities = courseReviewRepository.findAll();
        return courseReviewMapper.toDTOs(courseReviewEntities);
    }
    @Override
    public CourseReviewResponse updateCourseReview(Integer id, CourseReviewRequest courseReviewRequest) {
        var newCourseReview = courseReviewRepository.findById(id).orElse(new CourseReview());
        courseReviewMapper.mapUpdateRequestToEntity(newCourseReview, courseReviewRequest);
        courseReviewRepository.save(newCourseReview);
        return courseReviewMapper.toDTO(newCourseReview);
    }

    @Override
    public CourseReviewResponse createCourseReview(CourseReviewRequest courseReviewRequest) {
        var courseReviewEntity = courseReviewMapper.fromDTO(courseReviewRequest);
        courseReviewEntity = courseReviewRepository.save(courseReviewEntity);
        return courseReviewMapper.toDTO(courseReviewEntity);
    }

    @Override
    public void deleteCourseReview(Integer id) {
        courseReviewRepository.deleteById(id);
    }
}
