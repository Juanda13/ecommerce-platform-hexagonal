package com.juanlopez.ecommerce.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Domain model representing a customer order within the e-commerce platform.
 * <p>
 * An order aggregates one or more {@link OrderProduct} items and contains metadata such
 * as creation date, current state, and the identifier of the user who created it.
 * Being part of the domain layer, this model encapsulates business-related
 * information while remaining independent from infrastructure-specific concerns.
 */
@Data
@AllArgsConstructor
public class Order {

    /**
     * Unique identifier of the order.
     */
    private Integer id;

    /**
     * Date and time when the order was created.
     */
    private LocalDateTime dateCreated;

    /**
     * Collection of products associated with this order, each containing
     * quantity and pricing details.
     */
    private List<OrderProduct> orderProducts;

    /**
     * Current processing state of the order (e.g., CREATED, PAID, SHIPPED).
     */
    private OrderState orderState;

    /**
     * Identifier of the user who owns or created the order.
     */
    private Integer userId;

    /**
     * Default constructor initializing the list of order products.
     */
    public Order() {
        orderProducts = new ArrayList<>();
    }

    /**
     * Calculates the total monetary value of the order by summing the total cost of each
     * {@link OrderProduct} included in the order.
     *
     * @return Total aggregated price of all products in the order.
     */
    public BigDecimal getTotalOrderPrice() {
        return this.orderProducts.stream().map(OrderProduct::getTotalItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
