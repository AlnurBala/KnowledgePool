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
        log.info("Getting all categories");
        var categoryEntities = categoryRepository.findAll();
        log.debug("Retrieved {} categories", categoryEntities.size());
        return categoryMapper.toDTOs(categoryEntities);
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequest categoryRequest) {
        log.info("Creating a new category");
        var categoryEntity = categoryMapper.fromDTO(categoryRequest);
        categoryEntity = categoryRepository.save(categoryEntity);
        log.info("New category created with id: {}", categoryEntity.getCategoryId());
        return categoryMapper.toDTO(categoryEntity);
    }

    @Override
    public CategoryResponseDto updateCategory(Integer id, CategoryRequest categoryRequest) {
        log.info("Updating category with id: {}", id);
        var newCategory = categoryRepository.findById(id).orElse(new Category());
        categoryMapper.mapUpdateRequestToEntity(newCategory, categoryRequest);
        categoryRepository.save(newCategory);
        log.info("Category with id {} updated", id);
        return categoryMapper.toDTO(newCategory);
    }

    @Override
    public void deleteCategory(Integer id) {
        log.info("Deleting category with id: {}", id);
        categoryRepository.deleteById(id);
        log.info("Category with id {} deleted", id);
    }
}