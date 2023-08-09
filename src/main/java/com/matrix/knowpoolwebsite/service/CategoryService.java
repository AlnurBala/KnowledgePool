package com.matrix.knowpoolwebsite.service;

import com.matrix.knowpoolwebsite.dto.request.CategoryRequest;
import com.matrix.knowpoolwebsite.dto.response.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> getAllCategories();

    CategoryResponseDto createCategory(CategoryRequest categoryRequest);
    CategoryResponseDto updateCategory(Integer id, CategoryRequest categoryRequest);

    void deleteCategory(Integer id);
}
