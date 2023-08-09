package com.matrix.knowpoolwebsite.mapper;

import com.matrix.knowpoolwebsite.dto.request.CourseReviewRequest;
import com.matrix.knowpoolwebsite.dto.response.CourseReviewResponseDto;
import com.matrix.knowpoolwebsite.entity.CourseReview;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface CourseReviewMapper {
    CourseReview fromDTO(CourseReviewRequest courseReviewRequest);

    CourseReviewResponseDto toDTO(CourseReview courseReview);

    List<CourseReviewResponseDto> toDTOs(List<CourseReview> courseReviews);
    CourseReview mapUpdateRequestToEntity(@MappingTarget CourseReview courseReview, CourseReviewRequest courseReviewRequest);

}
