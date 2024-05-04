package com.joaobarbosa.ecommercecatalogv2.services;

import com.joaobarbosa.ecommercecatalogv2.dto.CategoryDTO;
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
    public CategoryDTO getById(Long id) {
        if (id != null) {
           return new CategoryDTO(categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Não localizamos registros de categorias com o id informado")));
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Page<CategoryDTO> getAll(Pageable pageable) {
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categories.map(CategoryDTO::new);
    }
}
