package com.juanlopez.ecommerce.backend.infrastructure.adapter;

import com.juanlopez.ecommerce.backend.infrastructure.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Spring Data JPA repository interface for {@link CategoryEntity}.
 * <p>
 * Provides CRUD operations for Category entities in the database.
 * <p>
 * This interface extends {@link CrudRepository}, so no additional
 * methods are required unless custom queries are needed.
 */
public interface ICategoryCrudRepository extends CrudRepository<CategoryEntity, Integer> {
}
