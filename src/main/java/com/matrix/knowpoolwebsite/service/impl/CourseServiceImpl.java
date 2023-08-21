package com.matrix.knowpoolwebsite.service.impl;

import com.matrix.knowpoolwebsite.dto.request.CourseRequest;
import com.matrix.knowpoolwebsite.dto.response.CourseResponseDto;
import com.matrix.knowpoolwebsite.entity.Course;
import com.matrix.knowpoolwebsite.mapper.CourseMapper;
import com.matrix.knowpoolwebsite.repository.CourseCriteria;
import com.matrix.knowpoolwebsite.repository.CourseRepository;
import com.matrix.knowpoolwebsite.service.CourseService;
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
    public Page<CourseResponseDto> getAllCourses(Pageable pageable) {
        log.info("Fetching all courses");
        var courseEntity = courseRepository.findAllPageable(pageable);
        return courseMapper.toDTOp(courseEntity);
    }

    @Override
    public Page<CourseResponseDto> getAllCoursesBySorting(Integer pageNumber, Integer pageSize, String sortProperty) {
        log.info("Fetching all courses by sorting");
        String defaultSortProperty = "title";
        String actualSortProperty = (sortProperty != null && !sortProperty.isEmpty()) ? sortProperty : defaultSortProperty;
        log.debug("Actual sort property: {}", actualSortProperty);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(actualSortProperty).ascending());

        var courseEntity = courseRepository.findAll(pageable);
        return courseMapper.toDTOp(courseEntity);
    }

    @Override
    public Page<CourseResponseDto> getCoursesByNameStartingWith(String prefix, Pageable pageable) {
        log.info("Fetching courses by name starting with: {}", prefix);
        Page<Course> courses = courseCriteria.getCoursesByNameStartingWith(prefix, pageable);
        return courses.map(courseMapper::toDTO);
    }

    @Override
    public Page<CourseResponseDto> getFilteredCoursesByDuration(Integer minDuration, Integer maxDuration, Pageable pageable) {
        log.info("Fetching filtered courses by duration ({} - {})", minDuration, maxDuration);
        Page<Course> courses = courseCriteria.getFilteredCoursesByDuration(minDuration, maxDuration, pageable);
        return courses.map(courseMapper::toDTO);
    }

    @Override
    public Page<CourseResponseDto> getAllCoursesByUploadDateSorting(Integer pageNumber, Integer pageSize) {
        log.info("Fetching all courses by upload date sorting");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("uploadDate").descending());

        var courseEntity = courseRepository.findAll(pageable);
        return courseMapper.toDTOp(courseEntity);
    }

    @Override
    public CourseResponseDto createCourse(CourseRequest courseRequest) {
        log.info("Creating new course: {}", courseRequest);
        var courseEntity = courseMapper.fromDTO(courseRequest);
        courseEntity.setStatus("NEW");
        courseEntity = courseRepository.save(courseEntity);
        return courseMapper.toDTO(courseEntity);
    }

    @Override
    public CourseResponseDto updateCourse(Integer id, CourseRequest courseRequest) {
        log.info("Updating course with ID {}: {}", id, courseRequest);
        var newCourse = courseRepository.findById(id).orElse(new Course());
        courseMapper.mapUpdateRequestToEntity(newCourse, courseRequest);
        newCourse = courseRepository.save(newCourse);
        return courseMapper.toDTO(newCourse);
    }

    @Override
    public void deleteCourse(Integer id) {
        log.info("Deleting course with ID: {}", id);
        courseRepository.deleteById(id);
    }
}