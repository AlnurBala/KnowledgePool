package com.matrix.knowpoolwebsite.service.impl;

import com.matrix.knowpoolwebsite.entity.Course;
import com.matrix.knowpoolwebsite.repository.CourseRepository;
import com.matrix.knowpoolwebsite.service.CourseScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseScheduleServiceImpl implements CourseScheduleService {
    private final CourseRepository courseRepository;

    @Override
    public List<Course> getCourseByStatus() {
        return courseRepository.findByStatus("NEW");
    }

    @Override
    public Course createCourse(Course course) {
        course.setStatus("NEW");
        return courseRepository.save(course);
    }

    @Override
    public void updateCourseStatus(Course course) {
        course.setStatus("UPDATED");
        courseRepository.save(course);
    }
}
