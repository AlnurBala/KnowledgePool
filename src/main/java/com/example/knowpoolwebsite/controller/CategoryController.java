package com.example.knowpoolwebsite.controller;

import com.example.knowpoolwebsite.dto.Request.CategoryRequest;
import com.example.knowpoolwebsite.dto.Response.CategoryResponse;
import com.example.knowpoolwebsite.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@Tag(name = "Category",description = "Category Management APIs")
public class CategoryController {
    private final CategoryService categoryService;

    /**
     *
     * @return
     */
    @GetMapping
    public List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public ResponseEntity< CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
        return new ResponseEntity<>(categoryService.createCategory(categoryRequest), HttpStatus.CREATED);

       // return ResponseEntity.of(Optional.of( categoryService.createCategory(categoryRequest)));
    }
    @PutMapping("{id}")
    public CategoryResponse updateCategory(@PathVariable Integer id, @RequestBody CategoryRequest categoryRequest) {
        return categoryService.updateCategory(id, categoryRequest);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCategoryById(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
