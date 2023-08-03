package com.example.knowpoolwebsite.mapper;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Request.CourseReviewRequest;
import com.example.knowpoolwebsite.dto.Request.DiscountRequest;
import com.example.knowpoolwebsite.dto.Response.CourseReviewResponse;
import com.example.knowpoolwebsite.dto.Response.DiscountResponse;
import com.example.knowpoolwebsite.entity.Course;
import com.example.knowpoolwebsite.entity.CourseReview;
import com.example.knowpoolwebsite.entity.Discount;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface DiscountMapper {
    Discount fromDTO(DiscountRequest discountRequest);

    DiscountResponse toDTO(Discount discount);

    List<DiscountResponse> toDTOs(List<Discount> discounts);

    Discount mapUpdateRequestToEntity(@MappingTarget Discount discount, DiscountRequest discountRequest);
}
