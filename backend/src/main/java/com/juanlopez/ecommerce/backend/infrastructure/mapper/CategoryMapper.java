package com.juanlopez.ecommerce.backend.infrastructure.mapper;

import com.juanlopez.ecommerce.backend.domain.model.Category;
import com.juanlopez.ecommerce.backend.infrastructure.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between {@link Category} domain models
 * and {@link CategoryEntity} persistence entities.
 * <p>
 * Uses MapStruct to automatically generate the implementation.
 * This mapper is part of the infrastructure layer and is injected
 * as a Spring component.
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    /**
     * Converts a {@link CategoryEntity} to a {@link Category} domain model.
     *
     * @param categoryEntity the entity to convert
     * @return the corresponding domain model
     */
    Category toCategory(CategoryEntity categoryEntity);

    /**
     * Converts an iterable collection of {@link CategoryEntity} objects
     * to an iterable collection of {@link Category} domain models.
     *
     * @param categoryEntities the entities to convert
     * @return an iterable of corresponding domain models
     */
    Iterable<Category> toCategories(Iterable<CategoryEntity> categoryEntities);

    /**
     * Converts a {@link Category} domain model to a {@link CategoryEntity}.
     * <p>
     * Inherits mapping configuration from {@link #toCategory(CategoryEntity)}.
     *
     * @param category the domain model to convert
     * @return the corresponding persistence entity
     */
    @InheritInverseConfiguration
    CategoryEntity toCategoryEntity(Category category);
}
