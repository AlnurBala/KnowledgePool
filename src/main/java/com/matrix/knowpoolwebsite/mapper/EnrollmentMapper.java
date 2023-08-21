package com.matrix.knowpoolwebsite.mapper;

import com.matrix.knowpoolwebsite.dto.request.EnrollmentRequest;
import com.matrix.knowpoolwebsite.dto.response.EnrollmentResponseDto;
import com.matrix.knowpoolwebsite.entity.Enrollment;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface EnrollmentMapper {
    Enrollment fromDTO(EnrollmentRequest enrollmentRequest);

    EnrollmentResponseDto toDTO(Enrollment enrollment);

    List<EnrollmentResponseDto> toDTOs(List<Enrollment> enrollments);

    Enrollment mapUpdateRequestToEntity(@MappingTarget Enrollment enrollment, EnrollmentRequest enrollmentRequest);

}
