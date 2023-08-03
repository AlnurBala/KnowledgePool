package com.example.knowpoolwebsite.service;

import com.example.knowpoolwebsite.dto.Request.CategoryRequest;
import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Response.CategoryResponse;
import com.example.knowpoolwebsite.dto.Response.CourseResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();

    CategoryResponse createCategory(CategoryRequest categoryRequest);
    CategoryResponse updateCategory(Integer id, CategoryRequest categoryRequest);

    void deleteCategory(Integer id);
}
