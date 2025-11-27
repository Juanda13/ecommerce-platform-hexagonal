package com.juanlopez.ecommerce.backend.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * JPA entity representing the association between an order and a specific product.
 * <p>
 * This entity stores quantity and pricing information for a product included
 * within an order. It forms part of the infrastructure layer and maps the
 * corresponding domain model to a relational database structure.
 */
@Data
@Entity
@Table(name = "order_products")
public class OrderProductEntity {

    /**
     * Primary key of the order-product record.
     * <p>
     * Automatically generated using the database identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Quantity of the product included in the order.
     */
    private BigDecimal quantity;

    /**
     * Unit price of the product at the moment the order was created.
     */
    private BigDecimal price;

    /**
     * Identifier of the product referenced by this entry.
     * <p>
     * Stored as a simple foreign key rather than a JPA relationship,
     * which provides flexibility and avoids unnecessary entity loading.
     */
    private Integer productId;

    /**
     * Reference to the order to which this product belongs.
     * <p>
     * Represents the many-to-one side of the order–order-products relationship,
     * where multiple product records can be associated with a single order.
     */
    @ManyToOne
    private OrderEntity orderEntity;

}
