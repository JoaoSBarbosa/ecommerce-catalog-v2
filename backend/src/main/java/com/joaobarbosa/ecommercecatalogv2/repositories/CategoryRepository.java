package com.joaobarbosa.ecommercecatalogv2.repositories;

import com.joaobarbosa.ecommercecatalogv2.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
