package com.example.knowpoolwebsite.service.impl;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Response.CourseResponse;
import com.example.knowpoolwebsite.entity.Course;
import com.example.knowpoolwebsite.mapper.CourseMapper;
import com.example.knowpoolwebsite.repository.CourseCriteria;
import com.example.knowpoolwebsite.repository.CourseRepository;
import com.example.knowpoolwebsite.repository.DiscountRepository;
import com.example.knowpoolwebsite.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


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
//        Pageable pageable=null;
//        if(null!=sortProperty){
//            pageable= PageRequest.of(pageNumber,pageSize, Sort.Direction.ASC,sortProperty);
//        }else {
//            pageable= PageRequest.of(pageNumber,pageSize, Sort.Direction.ASC,"title");
//        }
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
    public List<CourseResponse> getCoursesByNameStartingWith(String prefix) {
        List<Course> courses = courseCriteria.getCoursesByNameStartingWith(prefix);
        return courseMapper.toDTOs(courses);
    }
    @Override
    public Page<CourseResponse> getFilteredCoursesByDuration(Integer minDuration, Integer maxDuration, Pageable pageable) {
        Page<Course> courses = courseCriteria.getFilteredCoursesByDuration(minDuration, maxDuration, pageable);
        return courses.map(courseMapper::toDTO);
    }
//    @Override
//    public List<CourseResponse> getFilteredCoursesByDuration(Integer minDuration, Integer maxDuration) {
//        List<Course> courses = courseCriteria.getFilteredCoursesByDuration(minDuration, maxDuration);
//        return courseMapper.toDTOs(courses);
//    }

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
