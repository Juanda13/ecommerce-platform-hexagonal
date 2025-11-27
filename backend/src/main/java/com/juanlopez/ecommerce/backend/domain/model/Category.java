package com.juanlopez.ecommerce.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Domain model representing a product category within the e-commerce platform.
 * <p>
 * A category groups related products under a common name. This model is part of the
 * domain layer and should remain free of infrastructure-specific annotations or logic.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    /**
     * Unique identifier of the category.
     */
    private Integer id;

    /**
     * Display name of the category.
     */
    private String name;

    /**
     * Date and time when the category was created.
     */
    private LocalDateTime dateCreated;

    /**
     * Date and time when the category information was last updated.
     */
    private LocalDateTime dateUpdated;

}
