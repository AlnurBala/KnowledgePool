package com.example.knowpoolwebsite.service;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Response.CourseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    Page<CourseResponse> getAllCourses(Pageable pageable);
    Page<CourseResponse> getAllCoursesBySorting(Integer pageNumber,Integer pageSize,String sortProperty);
    CourseResponse createCourse(CourseRequest courseRequest);
    CourseResponse updateCourse(Integer id,CourseRequest courseRequest);
    void deleteCourse(Integer id);
    List<CourseResponse> getCoursesByNameStartingWith(String prefix);
    Page<CourseResponse> getFilteredCoursesByDuration(Integer minDuration, Integer maxDuration,Pageable pageable);
}

