package com.joaobarbosa.ecommercecatalogv2.model.services;

import com.joaobarbosa.ecommercecatalogv2.model.dto.CategoryDTO;
import com.joaobarbosa.ecommercecatalogv2.model.entities.Category;
import com.joaobarbosa.ecommercecatalogv2.model.services.exception.ControllerEntityNotFound;
import com.joaobarbosa.ecommercecatalogv2.repositories.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CategoryService {

    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Transactional(readOnly = true)
    public CategoryDTO getById(Long id) {

        if (id != null) {
            return new CategoryDTO(categoryRepository.findById(id).orElseThrow(() -> new ControllerEntityNotFound("Não localizamos registros de categorias com o id informado")));
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Page<CategoryDTO> getAll(Pageable pageable) {
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categories.map(CategoryDTO::new);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO source) {
        Category category = new Category();

        category.setName(source.getName());
        category = categoryRepository.save(category);
        return new CategoryDTO(category);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto) {
        try {
            Category category = categoryRepository.getOne(id);
            if (dto.getName() != null) category.setName(dto.getName());
            category = categoryRepository.save(category);
            return new CategoryDTO(category);
        } catch (EntityNotFoundException e) {
            throw new ControllerEntityNotFound("Não foi localizado registros de categoriaS com o id informado: "+id);
        }
    }
}
