package com.matrix.knowpoolwebsite.mapper;

import com.matrix.knowpoolwebsite.dto.request.CourseRequest;
import com.matrix.knowpoolwebsite.dto.response.CourseResponseDto;
import com.matrix.knowpoolwebsite.entity.Course;
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

    CourseResponseDto toDTO(Course course);

    List<CourseResponseDto> toDTOs(List<Course> courses);

    Course mapUpdateRequestToEntity(@MappingTarget Course course, CourseRequest courseRequest);

    default Page<CourseResponseDto> toDTOp(Page<Course> courses) {
        List<CourseResponseDto> courseResponseDtos = courses
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(courseResponseDtos, courses.getPageable(), courses.getTotalElements());
    }
}
