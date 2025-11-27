package com.juanlopez.ecommerce.backend.infrastructure.adapter;

import com.juanlopez.ecommerce.backend.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Spring Data repository interface for performing CRUD operations on products.
 * <p>
 * Extends {@link CrudRepository} to provide basic persistence functionality such as
 * creating, reading, updating, and deleting {@link ProductEntity} instances.
 * <p>
 * this interface belongs to the infrastructure layer and acts as the data access
 * adapter used by the application to interact with the underlying database.
 */
public interface IProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
}
