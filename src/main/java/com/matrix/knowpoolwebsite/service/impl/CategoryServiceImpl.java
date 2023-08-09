package com.matrix.knowpoolwebsite.service.impl;

import com.matrix.knowpoolwebsite.dto.request.CategoryRequest;
import com.matrix.knowpoolwebsite.dto.response.CategoryResponseDto;
import com.matrix.knowpoolwebsite.entity.Category;
import com.matrix.knowpoolwebsite.mapper.CategoryMapper;
import com.matrix.knowpoolwebsite.repository.CategoryRepository;
import com.matrix.knowpoolwebsite.service.CategoryService;
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
    public List<CategoryResponseDto> getAllCategories() {
        var categoryEntities = categoryRepository.findAll();
        return categoryMapper.toDTOs(categoryEntities);
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequest categoryRequest) {
        var categoryEntity = categoryMapper.fromDTO(categoryRequest);
        categoryEntity = categoryRepository.save(categoryEntity);
        return categoryMapper.toDTO(categoryEntity);
    }

    @Override
    public CategoryResponseDto updateCategory(Integer id, CategoryRequest categoryRequest) {
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
