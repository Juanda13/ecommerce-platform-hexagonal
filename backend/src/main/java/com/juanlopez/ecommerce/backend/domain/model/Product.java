package com.juanlopez.ecommerce.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Domain model representing a product within the e-commerce platform.
 * <p>
 * A product contains descriptive, pricing, and relational information.
 * This model is part of the domain layer and should remain independent
 * of infrastructure-specific annotations or behavior.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    /**
     * Unique identifier of the product.
     */
    private Integer id;

    /**
     * Display name of the product.
     */
    private String name;

    /**
     * Unique code used to identify the product within the system.
     */
    private String code;

    /**
     * Textual description providing product details.
     */
    private String description;

    /**
     * URL pointing to the main image of the product.
     */
    private String urlImage;

    /**
     * Current price of the product.
     */
    private BigDecimal price;

    /**
     * Date and time when the product was first created.
     */
    private LocalDateTime dateCreated;

    /**
     * Date and time when the product was last updated.
     */
    private LocalDateTime dateUpdated;

    /**
     * Identifier of the user who created or manages this product.
     */
    private Integer userId;

    /**
     * Identifier of the category to which this product belongs.
     */
    private Integer categoryId;

}
