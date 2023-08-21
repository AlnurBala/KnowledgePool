package com.matrix.knowpoolwebsite.mapper;

import com.matrix.knowpoolwebsite.dto.request.InstructorRequest;
import com.matrix.knowpoolwebsite.dto.response.InstructorResponseDto;
import com.matrix.knowpoolwebsite.entity.Instructor;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface InstructorMapper {
    Instructor fromDTO(InstructorRequest instructorRequest);

    InstructorResponseDto toDTO(Instructor instructor);

    List<InstructorResponseDto> toDTOs(List<Instructor> instructors);

    Instructor mapUpdateRequestToEntity(@MappingTarget Instructor instructor, InstructorRequest instructorRequest);

}
