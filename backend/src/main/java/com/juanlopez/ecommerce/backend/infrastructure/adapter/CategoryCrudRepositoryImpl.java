package com.juanlopez.ecommerce.backend.infrastructure.adapter;

import com.juanlopez.ecommerce.backend.domain.model.Category;
import com.juanlopez.ecommerce.backend.domain.port.ICategoryRepository;
import com.juanlopez.ecommerce.backend.infrastructure.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

/**
 * Implementation of {@link ICategoryRepository} using Spring Data JPA.
 * <p>
 * Acts as an adapter between the domain layer and the persistence layer.
 * Handles CRUD operations for {@link Category} entities and maps them
 * between domain and database representations using {@link CategoryMapper}.
 */
@Repository
public class CategoryCrudRepositoryImpl implements ICategoryRepository {

    private final ICategoryCrudRepository iCategoryCrudRepository;
    private final CategoryMapper categoryMapper;

    /**
     * Constructs a new {@code CategoryCrudRepositoryImpl} with the given
     * JPA repository and mapper.
     *
     * @param iCategoryCrudRepository the Spring Data repository for Category entities
     * @param categoryMapper the mapper to convert between domain and entity objects
     */
    public CategoryCrudRepositoryImpl(ICategoryCrudRepository iCategoryCrudRepository, CategoryMapper categoryMapper) {
        this.iCategoryCrudRepository = iCategoryCrudRepository;
        this.categoryMapper = categoryMapper;
    }

    /**
     * Saves a new category or updates an existing one.
     *
     * @param category the category to save
     * @return the persisted category mapped back to the domain model
     */
    @Override
    public Category save(Category category) {
        return categoryMapper.toCategory(iCategoryCrudRepository.save(categoryMapper.toCategoryEntity(category)));
    }

    /**
     * Retrieves all categories.
     *
     * @return an iterable collection of categories mapped to the domain model
     */
    @Override
    public Iterable<Category> findAll() {
        return categoryMapper.toCategories(iCategoryCrudRepository.findAll());
    }

    /**
     * Finds a category by its ID.
     *
     * @param id the category ID
     * @return the category if found
     * @throws RuntimeException if the category does not exist
     */
    @Override
    public Category findById(Integer id) {
        return categoryMapper.toCategory(iCategoryCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Categoría con id: " + id + " no existe.")
        ));
    }

    /**
     * Deletes a category by its ID.
     * <p>
     * Delegates the deletion to the underlying Spring Data repository.
     * This method is intentionally empty in terms of logic beyond delegation.
     *
     * @param id the ID of the category to delete
     */
    @Override
    public void deleteById(Integer id) {
        iCategoryCrudRepository.deleteById(id);
    }
    
}
