package com.example.knowpoolwebsite.mapper;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Request.CourseReviewRequest;
import com.example.knowpoolwebsite.dto.Response.CourseReviewResponse;
import com.example.knowpoolwebsite.entity.Course;
import com.example.knowpoolwebsite.entity.CourseReview;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface CourseReviewMapper {
    CourseReview fromDTO(CourseReviewRequest courseReviewRequest);

    CourseReviewResponse toDTO(CourseReview courseReview);

    List<CourseReviewResponse> toDTOs(List<CourseReview> courseReviews);
    CourseReview mapUpdateRequestToEntity(@MappingTarget CourseReview courseReview, CourseReviewRequest courseReviewRequest);

}
