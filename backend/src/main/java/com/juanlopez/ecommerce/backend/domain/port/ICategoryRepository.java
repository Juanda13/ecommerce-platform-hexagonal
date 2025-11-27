package com.juanlopez.ecommerce.backend.domain.port;

import com.juanlopez.ecommerce.backend.domain.model.Category;

/**
 * Repository interface for managing {@link Category} persistence operations.
 * <p>
 * This interface defines the contract for storing, retrieving, and deleting categories.
 * Implementations of this interface reside in the infrastructure layer.
 */
public interface ICategoryRepository {

    /**
     * Saves a new category or updates an existing one.
     *
     * @param category the category to save
     * @return the persisted category
     */
    Category save(Category category);

    /**
     * Retrieves all categories.
     *
     * @return an iterable collection of categories
     */
    Iterable<Category> findAll();

    /**
     * Finds a category by its ID.
     *
     * @param id the category ID
     * @return the category if found
     * @throws RuntimeException if the category does not exist (implementation-specific)
     */
    Category findById(Integer id);

    /**
     * Deletes a category by its ID.
     * <p>
     * This method is implemented in the infrastructure layer.
     *
     * @param id the ID of the category to delete
     */
    void deleteById(Integer id);

}
