package com.juanlopez.ecommerce.backend.domain.port;

import com.juanlopez.ecommerce.backend.domain.model.Category;

public interface ICategoryRepository {

    Category save(Category category);
    Iterable<Category> findAll();
    Category findById(Integer id);
    void deleteById(Integer id);

}
