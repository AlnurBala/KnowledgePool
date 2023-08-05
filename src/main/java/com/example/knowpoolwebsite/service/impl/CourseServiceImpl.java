package com.example.knowpoolwebsite.service.impl;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Response.CourseResponse;
import com.example.knowpoolwebsite.entity.Course;
import com.example.knowpoolwebsite.mapper.CourseMapper;
import com.example.knowpoolwebsite.repository.CourseCriteria;
import com.example.knowpoolwebsite.repository.CourseRepository;
import com.example.knowpoolwebsite.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final CourseCriteria courseCriteria;
    @Override
    public Page<CourseResponse> getAllCourses(Pageable pageable) {
        var courseEntity = courseRepository.findAllPageable(pageable);
        return courseMapper.toDTOp(courseEntity);
    }
    @Override
    public Page<CourseResponse> getAllCoursesBySorting(Integer pageNumber, Integer pageSize,String sortProperty) {
        String defaultSortProperty = "title";

        // Check if sortProperty is null or empty, use the defaultSortProperty
        String actualSortProperty = (sortProperty != null && !sortProperty.isEmpty()) ? sortProperty : defaultSortProperty;
        log.info("Actual sort property: {}", actualSortProperty);
        // Create the Pageable with sorting based on the actualSortProperty
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(actualSortProperty).ascending());

        var courseEntity = courseRepository.findAll(pageable);
        return courseMapper.toDTOp(courseEntity);
    }

    @Override
    public Page<CourseResponse> getCoursesByNameStartingWith(String prefix, Pageable pageable) {
        Page<Course> courses = courseCriteria.getCoursesByNameStartingWith(prefix, pageable);
        return courses.map(courseMapper::toDTO);
    }
    @Override
    public Page<CourseResponse> getFilteredCoursesByDuration(Integer minDuration, Integer maxDuration, Pageable pageable) {
        Page<Course> courses = courseCriteria.getFilteredCoursesByDuration(minDuration, maxDuration, pageable);
        return courses.map(courseMapper::toDTO);
    }

    @Override
    public Page<CourseResponse> getAllCoursesByUploadDateSorting(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("uploadDate").descending());

        var courseEntity = courseRepository.findAll(pageable);
        return courseMapper.toDTOp(courseEntity);
    }

    @Override
    public CourseResponse createCourse(CourseRequest courseRequest) {
        var courseEntity = courseMapper.fromDTO(courseRequest);
        courseEntity.setStatus("NEW");
        courseEntity = courseRepository.save(courseEntity);
        return courseMapper.toDTO(courseEntity);
    }

    @Override
    public CourseResponse updateCourse(Integer id, CourseRequest courseRequest) {
        var newCourse = courseRepository.findById(id).orElse(new Course());
        courseMapper.mapUpdateRequestToEntity(newCourse, courseRequest);
        courseRepository.save(newCourse);
        return courseMapper.toDTO(newCourse);
    }

    @Override
    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }
}
