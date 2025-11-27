package com.juanlopez.ecommerce.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Domain model representing a product entry within an order.
 * <p>
 * Each {@link OrderProduct} instance defines the quantity and pricing details
 * for a specific product included in a customer order. This model forms part of
 * the domain layer and should remain independent of infrastructure-specific
 * behaviors or annotations.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {

    /**
     * Unique identifier of the order-product association.
     */
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
     * Identifier of the product to which this entry refers.
     */
    private Integer productId;

    /**
     * Calculates the total cost for this item based on the unit price
     * multiplied by the quantity.
     *
     * @return Total cost for this specific product within the order.
     */
    public BigDecimal getTotalItem() {
        return this.price.multiply(quantity);
    }

}
