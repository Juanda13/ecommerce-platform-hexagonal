package com.juanlopez.ecommerce.backend.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * JPA entity representing a category in the database.
 * <p>
 * Maps to the {@code categories} table and contains fields for
 * the category ID, name, and auditing timestamps.
 * This class is part of the infrastructure layer and is used
 * by Spring Data JPA for persistence operations.
 */
@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
public class CategoryEntity {

    /**
     * Primary key of the category.
     * <p>
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Name of the category.
     */
    private String name;

    /**
     * Timestamp of when the category was created.
     * <p>
     * Automatically set by Hibernate on creation.
     */
    @CreationTimestamp
    private LocalDateTime dateCreated;

    /**
     * Timestamp of when the category was last updated.
     * <p>
     * Automatically updated by Hibernate on modification.
     */
    @UpdateTimestamp
    private LocalDateTime dateUpdated;

}
