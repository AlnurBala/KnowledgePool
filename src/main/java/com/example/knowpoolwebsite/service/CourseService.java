package com.example.knowpoolwebsite.service;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Response.CourseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
    Page<CourseResponse> getAllCourses(Pageable pageable);
    Page<CourseResponse> getAllCoursesBySorting(Integer pageNumber,Integer pageSize,String sortProperty);
    CourseResponse createCourse(CourseRequest courseRequest);
    CourseResponse updateCourse(Integer id,CourseRequest courseRequest);
    void deleteCourse(Integer id);
    Page<CourseResponse> getCoursesByNameStartingWith(String prefix, Pageable pageable);
    Page<CourseResponse> getFilteredCoursesByDuration(Integer minDuration, Integer maxDuration,Pageable pageable);
    Page<CourseResponse> getAllCoursesByUploadDateSorting(Integer pageNumber, Integer pageSize);
}

