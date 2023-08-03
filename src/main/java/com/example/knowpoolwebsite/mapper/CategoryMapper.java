package com.example.knowpoolwebsite.mapper;

import com.example.knowpoolwebsite.dto.Request.CategoryRequest;
import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Response.CategoryResponse;
import com.example.knowpoolwebsite.entity.Category;
import com.example.knowpoolwebsite.entity.Course;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface CategoryMapper {
    Category fromDTO(CategoryRequest categoryRequest);

    CategoryResponse toDTO(Category category);

    List<CategoryResponse> toDTOs(List<Category> categories);
    Category mapUpdateRequestToEntity(@MappingTarget Category category, CategoryRequest categoryRequest);

}
