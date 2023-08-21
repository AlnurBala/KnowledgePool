package com.matrix.knowpoolwebsite.service;

import com.matrix.knowpoolwebsite.dto.request.CourseRequest;
import com.matrix.knowpoolwebsite.dto.response.CourseResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
    Page<CourseResponseDto> getAllCourses(Pageable pageable);

    Page<CourseResponseDto> getAllCoursesBySorting(Integer pageNumber, Integer pageSize, String sortProperty);

    CourseResponseDto createCourse(CourseRequest courseRequest);

    CourseResponseDto updateCourse(Integer id, CourseRequest courseRequest);

    void deleteCourse(Integer id);

    Page<CourseResponseDto> getCoursesByNameStartingWith(String prefix, Pageable pageable);

    Page<CourseResponseDto> getFilteredCoursesByDuration(Integer minDuration, Integer maxDuration, Pageable pageable);

    Page<CourseResponseDto> getAllCoursesByUploadDateSorting(Integer pageNumber, Integer pageSize);
}

