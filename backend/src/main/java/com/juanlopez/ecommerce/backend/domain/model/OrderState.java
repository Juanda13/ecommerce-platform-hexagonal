package com.juanlopez.ecommerce.backend.domain.model;

/**
 * Enumeration representing the possible processing states of an order
 * within the e-commerce platform.
 * <p>
 * These states reflect the current lifecycle step of an order and are used
 * throughout the domain layer to control business logic related to order
 * transitions. Being part of the domain model, this enum is intentionally kept
 * free from infrastructure or framework dependencies.
 */
public enum OrderState {

    /**
     * Indicates that the order has been cancelled and will no longer proceed
     * through the fulfillment workflow.
     */
    CANCELLED,

    /**
     * Indicates that the order has been confirmed and is valid for continued
     * processing (e.g., payment, preparation, shipment).
     */
    CONFIRMED
}
