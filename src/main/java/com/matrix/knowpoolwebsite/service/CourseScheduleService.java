package com.matrix.knowpoolwebsite.service;

import com.matrix.knowpoolwebsite.entity.Course;

import java.util.List;

public interface CourseScheduleService {
    List<Course> getCourseByStatus();

    void updateCourseStatus(Course course);

    Course createCourse(Course course);
}
