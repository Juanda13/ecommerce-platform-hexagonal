package com.juanlopez.ecommerce.backend.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * JPA entity representing a product in the database.
 * <p>
 * Maps to the {@code products} table and contains fields for product identity,
 * descriptive information, pricing, category assignment, ownership, and auditing data.
 * This class is part of the infrastructure layer and is used
 * by Spring Data JPA for persistence operations.
 */
@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class ProductEntity {

    /**
     * Primary key of the product.
     * <p>
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Name of the product.
     */
    private String name;

    /**
     * Unique internal code used to identify and reference the product.
     */
    private String code;

    /**
     * Detailed description of the product.
     */
    private String description;

    /**
     * URL pointing to the product's representative image.
     */
    private String urlImage;

    /**
     * Unit price of the product.
     */
    private BigDecimal price;

    /**
     * Timestamp of when the product was created.
     * <p>
     * Automatically set by Hibernate on creation.
     */
    @CreationTimestamp
    private LocalDateTime dateCreated;

    /**
     * Timestamp of when the product was last updated.
     * <p>
     * Automatically updated by Hibernate on modification.
     */
    @UpdateTimestamp
    private LocalDateTime dateUpdated;

    /**
     * User who created or owns this product.
     * <p>
     * Defines a many-to-one relationship where multiple products
     * can be associated with a single user.
     */
    @ManyToOne
    private UserEntity userEntity;

    /**
     * Category to which this product belongs.
     * <p>
     * Defines a many-to-one relationship where multiple products
     * can be grouped under a single category.
     */
    @ManyToOne
    private CategoryEntity categoryEntity;

}
