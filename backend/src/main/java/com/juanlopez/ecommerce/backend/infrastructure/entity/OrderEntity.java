package com.juanlopez.ecommerce.backend.infrastructure.entity;

import com.juanlopez.ecommerce.backend.domain.model.OrderState;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

/**
 * JPA entity representing the persistent state of an order within the database.
 * <p>
 * This entity maps the domain concept of an order to the underlying relational
 * structure. It contains metadata such as creation date, state, and relational
 * links to user and product details. While it reflects the domain model, this
 * class is part of the infrastructure layer and includes annotations and behavior
 * specific to JPA and Hibernate.
 */
@Entity
@Table(name = "orders")
@Data
public class OrderEntity {

    /**
     * Primary key of the order record.
     * <p>
     * Automatically generated using the database identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Timestamp indicating when the order was created.
     * <p>
     * Automatically assigned by Hibernate at the moment of persistence.
     */
    @CreationTimestamp
    private LocalDateTime dateCreated;

    /**
     * Current state of the order.
     * <p>
     * Stored as a string representation of the {@link OrderState} enum.
     */
    @Enumerated(value = EnumType.STRING)
    private OrderState orderState;

    /**
     * Reference to the user who created or owns the order.
     * <p>
     * Defines a many-to-one relationship, where multiple orders can be
     * associated with a single user.
     */
    @ManyToOne
    private UserEntity userEntity;

    /**
     * Collection of products associated with this order.
     * <p>
     * Represents a one-to-many bidirectional relationship, where each
     * {@link OrderProductEntity} holds a reference back to this entity.
     * Cascade type PERSIST ensures that new product items are persisted
     * automatically when the order entity is saved.
     */
    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.PERSIST)
    private List<OrderProductEntity> orderProducts;
}
