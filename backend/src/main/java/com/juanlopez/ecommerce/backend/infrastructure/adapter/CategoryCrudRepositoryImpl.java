package com.juanlopez.ecommerce.backend.infrastructure.adapter;

import com.juanlopez.ecommerce.backend.domain.model.Category;
import com.juanlopez.ecommerce.backend.domain.port.ICategoryRepository;
import com.juanlopez.ecommerce.backend.infrastructure.mapper.ICategoryMapper;
import org.springframework.stereotype.Repository;

/**
 * Implementation of {@link ICategoryRepository} using Spring Data JPA.
 * <p>
 * Acts as an adapter between the domain layer and the persistence layer.
 * Handles CRUD operations for {@link Category} entities and maps them
 * between domain and database representations using {@link ICategoryMapper}.
 */
@Repository
public class CategoryCrudRepositoryImpl implements ICategoryRepository {

    private final ICategoryCrudRepository iCategoryCrudRepository;
    private final ICategoryMapper iCategoryMapper;

    /**
     * Constructs a new {@code CategoryCrudRepositoryImpl} with the given
     * JPA repository and mapper.
     *
     * @param iCategoryCrudRepository the Spring Data repository for Category entities
     * @param iCategoryMapper the mapper to convert between domain and entity objects
     */
    public CategoryCrudRepositoryImpl(ICategoryCrudRepository iCategoryCrudRepository, ICategoryMapper iCategoryMapper) {
        this.iCategoryCrudRepository = iCategoryCrudRepository;
        this.iCategoryMapper = iCategoryMapper;
    }

    /**
     * Saves a new category or updates an existing one.
     *
     * @param category the category to save
     * @return the persisted category mapped back to the domain model
     */
    @Override
    public Category save(Category category) {
        return iCategoryMapper.toCategory(iCategoryCrudRepository.save(iCategoryMapper.toCategoryEntity(category)));
    }

    /**
     * Retrieves all categories.
     *
     * @return an iterable collection of categories mapped to the domain model
     */
    @Override
    public Iterable<Category> findAll() {
        return iCategoryMapper.toCategories(iCategoryCrudRepository.findAll());
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
        return iCategoryMapper.toCategory(iCategoryCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Categoría con id: " + id + " no existe.")
        ));
    }

    /**
     * Deletes a category by its unique identifier.
     * <p>
     * Before deletion, the method verifies that the category exists in the database.
     * If no product is found with the given ID, a {@link RuntimeException} is thrown.
     *
     * @param id the identifier of the category to delete
     * @throws RuntimeException if the category does not exist
     */
    @Override
    public void deleteById(Integer id) {
        // Validate that the category exists before deleting
        iCategoryCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Categoría con id: " + id + " no existe.")
        );
        iCategoryCrudRepository.deleteById(id);
    }
    
}
