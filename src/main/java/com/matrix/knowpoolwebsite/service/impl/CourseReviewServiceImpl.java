package com.matrix.knowpoolwebsite.service.impl;

import com.matrix.knowpoolwebsite.dto.request.CourseReviewRequest;
import com.matrix.knowpoolwebsite.dto.response.CourseReviewResponseDto;
import com.matrix.knowpoolwebsite.entity.CourseReview;
import com.matrix.knowpoolwebsite.mapper.CourseReviewMapper;
import com.matrix.knowpoolwebsite.repository.CourseReviewRepository;
import com.matrix.knowpoolwebsite.service.CourseReviewService;
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
    public List<CourseReviewResponseDto> getAllCourseReviews() {
        log.debug("Getting all course reviews");
        var courseReviewEntities = courseReviewRepository.findAll();
        return courseReviewMapper.toDTOs(courseReviewEntities);
    }

    @Override
    public CourseReviewResponseDto updateCourseReview(Integer id, CourseReviewRequest courseReviewRequest) {
        log.info("Updating course review with ID {}: {}", id, courseReviewRequest);
        var newCourseReview = courseReviewRepository.findById(id).orElse(new CourseReview());
        courseReviewMapper.mapUpdateRequestToEntity(newCourseReview, courseReviewRequest);
        newCourseReview = courseReviewRepository.save(newCourseReview);
        return courseReviewMapper.toDTO(newCourseReview);
    }

    @Override
    public CourseReviewResponseDto createCourseReview(CourseReviewRequest courseReviewRequest) {
        log.debug("Creating new course review: {}", courseReviewRequest);
        var courseReviewEntity = courseReviewMapper.fromDTO(courseReviewRequest);
        courseReviewEntity = courseReviewRepository.save(courseReviewEntity);
        return courseReviewMapper.toDTO(courseReviewEntity);
    }

    @Override
    public void deleteCourseReview(Integer id) {
        log.info("Deleting course review with ID {}", id);
        try {
            courseReviewRepository.deleteById(id);
            log.info("Course review with ID {} deleted successfully", id);
        } catch (Exception e) {
            log.error("Error occurred while deleting course review with ID {}: {}", id, e.getMessage());
        }
    }
}
