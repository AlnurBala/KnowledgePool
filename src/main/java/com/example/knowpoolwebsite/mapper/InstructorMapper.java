package com.example.knowpoolwebsite.mapper;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Request.InstructorRequest;
import com.example.knowpoolwebsite.dto.Response.InstructorResponse;
import com.example.knowpoolwebsite.entity.Course;
import com.example.knowpoolwebsite.entity.Instructor;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface InstructorMapper {
    Instructor fromDTO(InstructorRequest instructorRequest);

    InstructorResponse toDTO(Instructor instructor);

    List<InstructorResponse> toDTOs(List<Instructor> instructors);
    Instructor mapUpdateRequestToEntity(@MappingTarget Instructor instructor, InstructorRequest instructorRequest);

}
