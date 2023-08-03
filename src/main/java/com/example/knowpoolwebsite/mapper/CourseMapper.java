package com.example.knowpoolwebsite.mapper;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Response.CourseResponse;
import com.example.knowpoolwebsite.entity.Course;
import org.mapstruct.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface CourseMapper {
    Course fromDTO(CourseRequest courseRequest);

    CourseResponse toDTO(Course course);

    List<CourseResponse> toDTOs(List<Course> courses);
    Course mapUpdateRequestToEntity(@MappingTarget Course course,CourseRequest courseRequest);

    default Page<CourseResponse> toDTOp(Page<Course> courses) {
        List<CourseResponse> courseResponses = courses
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(courseResponses, courses.getPageable(), courses.getTotalElements());
    }
}
