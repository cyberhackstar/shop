package com.shop.ShopService.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.shop.ShopService.service.CategoryService;
import com.shop.ShopService.dto.CategoryDTO;
import com.shop.ShopService.utility.DtoMapper;
import com.shop.ShopService.model.Category;

@RestController
@RequestMapping("/api/categorys")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAll() {
        return categoryService.findAll().stream()
                .map(DtoMapper::mapCategoryToDto)
                .toList();
    }

    @GetMapping("/{id}")
    public CategoryDTO getById(@PathVariable Long id) {
        Category category = categoryService.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return DtoMapper.mapCategoryToDto(category);
    }

    @PostMapping
    public CategoryDTO create(@RequestBody Category category) {
        return DtoMapper.mapCategoryToDto(categoryService.save(category));
    }

    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable Long id, @RequestBody Category updated) {
        return DtoMapper.mapCategoryToDto(categoryService.update(id, updated));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteById(id);
    }

}
