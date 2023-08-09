package com.matrix.knowpoolwebsite.mapper;

import com.matrix.knowpoolwebsite.dto.request.CategoryRequest;
import com.matrix.knowpoolwebsite.dto.response.CategoryResponseDto;
import com.matrix.knowpoolwebsite.entity.Category;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface CategoryMapper {
    Category fromDTO(CategoryRequest categoryRequest);

    CategoryResponseDto toDTO(Category category);

    List<CategoryResponseDto> toDTOs(List<Category> categories);
    Category mapUpdateRequestToEntity(@MappingTarget Category category, CategoryRequest categoryRequest);

}
