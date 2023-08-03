package com.example.knowpoolwebsite.mapper;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Request.EnrollmentRequest;
import com.example.knowpoolwebsite.dto.Response.EnrollmentResponse;
import com.example.knowpoolwebsite.entity.Course;
import com.example.knowpoolwebsite.entity.Enrollment;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface EnrollmentMapper {
    Enrollment fromDTO(EnrollmentRequest enrollmentRequest);

    EnrollmentResponse toDTO(Enrollment enrollment);

    List<EnrollmentResponse> toDTOs(List<Enrollment> enrollments);
    Enrollment mapUpdateRequestToEntity(@MappingTarget Enrollment enrollment, EnrollmentRequest enrollmentRequest);

}
