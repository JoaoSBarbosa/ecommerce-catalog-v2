package com.joaobarbosa.ecommercecatalogv2.controllers;

import com.joaobarbosa.ecommercecatalogv2.dto.CategoryDTO;
import com.joaobarbosa.ecommercecatalogv2.entities.Category;
import com.joaobarbosa.ecommercecatalogv2.services.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Long id) {
        CategoryDTO category = categoryService.getById(id);

        return ResponseEntity.ok().body(category);
    }

    @GetMapping
    public ResponseEntity<Page<CategoryDTO>> findAllCategories(Pageable pageable) {
        Page<CategoryDTO> categories = categoryService.getAll(pageable);
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/teste")
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Livros"));
        categories.add(new Category(2L, "Professors"));
        categories.add(new Category(3L, "Computadores"));
        categories.add(new Category(4L, "Computadores"));
        categories.add(new Category(5L, "Computadores"));
        return ResponseEntity.ok().body(categories);
    }
}
