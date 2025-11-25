package com.juanlopez.ecommerce.backend.infrastructure.adapter;

import com.juanlopez.ecommerce.backend.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Spring Data JPA repository interface for {@link UserEntity}.
 * <p>
 * Provides CRUD operations for User entities in the database.
 * <p>
 * This interface extends {@link CrudRepository}, so no additional
 * methods are required unless custom queries are needed.
 */
public interface IUserCrudRepository extends CrudRepository<UserEntity, Integer> {
}
