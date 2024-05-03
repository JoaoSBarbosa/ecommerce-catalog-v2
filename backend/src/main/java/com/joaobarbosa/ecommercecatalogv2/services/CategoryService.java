package com.joaobarbosa.ecommercecatalogv2.services;

import com.joaobarbosa.ecommercecatalogv2.entities.Category;
import com.joaobarbosa.ecommercecatalogv2.repositories.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Transactional(readOnly = true)
    public Category getById(Long id) {
        if (id != null) {
            return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Não localizamos registros de categorias com o id informado"));
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
