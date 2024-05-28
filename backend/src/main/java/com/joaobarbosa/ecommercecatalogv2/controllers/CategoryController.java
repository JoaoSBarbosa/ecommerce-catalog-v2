package com.joaobarbosa.ecommercecatalogv2.controllers;

import com.joaobarbosa.ecommercecatalogv2.model.dto.CategoryDTO;
import com.joaobarbosa.ecommercecatalogv2.model.entities.Category;
import com.joaobarbosa.ecommercecatalogv2.model.services.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
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


    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO source) {
        source = categoryService.insert(source);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(source.getId()).toUri();

        return ResponseEntity.created(uri).body(source);
    }
}
