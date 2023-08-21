package com.matrix.knowpoolwebsite.controller;

import com.matrix.knowpoolwebsite.dto.request.CategoryRequest;
import com.matrix.knowpoolwebsite.dto.response.CategoryResponseDto;
import com.matrix.knowpoolwebsite.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
@Tag(name = "Category", description = "Category Management APIs")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponseDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryRequest categoryRequest) {
        return new ResponseEntity<>(categoryService.createCategory(categoryRequest), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public CategoryResponseDto updateCategory(@PathVariable Integer id, @RequestBody CategoryRequest categoryRequest) {
        return categoryService.updateCategory(id, categoryRequest);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCategoryById(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
