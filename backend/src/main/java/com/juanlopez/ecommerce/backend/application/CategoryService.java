package com.juanlopez.ecommerce.backend.application;

import com.juanlopez.ecommerce.backend.domain.model.Category;
import com.juanlopez.ecommerce.backend.domain.port.ICategoryRepository;

/**
 * Application service for managing {@link Category} operations.
 * <p>
 * This service acts as an intermediary between the domain layer and
 * the infrastructure layer, delegating persistence operations to
 * {@link ICategoryRepository}. It contains the application use cases
 * related to category management.
 */
public class CategoryService {

    private final ICategoryRepository iCategoryRepository;

    /**
     * Creates a new instance of {@code CategoryService}.
     *
     * @param iCategoryRepository the repository used for category persistence operations
     */
    public CategoryService(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    /**
     * Saves a new category or updates an existing one.
     *
     * @param category the category to save
     * @return the persisted category
     */
    public Category save(Category category) {
        return iCategoryRepository.save(category);
    }

    /**
     * Retrieves all categories.
     *
     * @return an iterable collection of categories
     */
    public Iterable<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    /**
     * Finds a category by its ID.
     *
     * @param id the category ID
     * @return the category if found
     * @throws RuntimeException if the category does not exist (as implemented by the repository)
     */
    public Category findById(Integer id) {
        return iCategoryRepository.findById(id);
    }

    /**
     * Deletes a category by its ID.
     * <p>
     * This method delegates the deletion to the repository. If the category
     * does no exist, the repository implementation determines the behavior.
     */
    public void deleteById(Integer id) {
        iCategoryRepository.deleteById(id);
    }

}
