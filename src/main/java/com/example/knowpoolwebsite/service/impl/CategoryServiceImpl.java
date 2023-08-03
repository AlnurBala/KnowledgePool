package com.example.knowpoolwebsite.service.impl;

import com.example.knowpoolwebsite.dto.Request.CategoryRequest;
import com.example.knowpoolwebsite.dto.Response.CategoryResponse;
import com.example.knowpoolwebsite.entity.Category;
import com.example.knowpoolwebsite.mapper.CategoryMapper;
import com.example.knowpoolwebsite.repository.CategoryRepository;
import com.example.knowpoolwebsite.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> getAllCategories() {
        var categoryEntities = categoryRepository.findAll();
        return categoryMapper.toDTOs(categoryEntities);
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        var categoryEntity = categoryMapper.fromDTO(categoryRequest);
        categoryEntity = categoryRepository.save(categoryEntity);
        return categoryMapper.toDTO(categoryEntity);
    }

    @Override
    public CategoryResponse updateCategory(Integer id, CategoryRequest categoryRequest) {
        var newCategory = categoryRepository.findById(id).orElse(new Category());
        categoryMapper.mapUpdateRequestToEntity(newCategory,categoryRequest );
        categoryRepository.save(newCategory);
        return categoryMapper.toDTO(newCategory);
    }


    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
