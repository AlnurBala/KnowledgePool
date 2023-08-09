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
        var courseReviewEntities = courseReviewRepository.findAll();
        return courseReviewMapper.toDTOs(courseReviewEntities);
    }
    @Override
    public CourseReviewResponseDto updateCourseReview(Integer id, CourseReviewRequest courseReviewRequest) {
        var newCourseReview = courseReviewRepository.findById(id).orElse(new CourseReview());
        courseReviewMapper.mapUpdateRequestToEntity(newCourseReview, courseReviewRequest);
        courseReviewRepository.save(newCourseReview);
        return courseReviewMapper.toDTO(newCourseReview);
    }

    @Override
    public CourseReviewResponseDto createCourseReview(CourseReviewRequest courseReviewRequest) {
        var courseReviewEntity = courseReviewMapper.fromDTO(courseReviewRequest);
        courseReviewEntity = courseReviewRepository.save(courseReviewEntity);
        return courseReviewMapper.toDTO(courseReviewEntity);
    }

    @Override
    public void deleteCourseReview(Integer id) {
        courseReviewRepository.deleteById(id);
    }
}
