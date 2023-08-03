package com.example.knowpoolwebsite.service;

import com.example.knowpoolwebsite.entity.Course;

import java.util.List;

public interface CourseScheduleService {
    List<Course>getCourseByStatus();
    void updateCourseStatus(Course course);
    Course createCourse(Course course);
}
