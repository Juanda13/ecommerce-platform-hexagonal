package com.juanlopez.ecommerce.backend.application;

import com.juanlopez.ecommerce.backend.domain.model.Order;
import com.juanlopez.ecommerce.backend.domain.port.IOrderRepository;

/**
 * Application service for managing orders.
 * <p>
 * This class acts as the service layer that coordinates operations on orders
 * between the infrastructure layer (repositories) and the presentation layer
 * (controllers or APIs).
 * <p>
 * It provides methods to create, retrieve, and update the state of orders.
 */
public class OrderService {

    private final IOrderRepository iOrderRepository;

    /**
     * Constructs an OrderService with the given order repository.
     *
     * @param iOrderRepository The repository implementation for orders.
     */
    public OrderService(IOrderRepository iOrderRepository) {
        this.iOrderRepository = iOrderRepository;
    }

    /**
     * Saves a new order or updates an existing one.
     *
     * @param order The order to save.
     * @return The persisted order, possibly updated with generated values (e.g., ID).
     */
    public Order save(Order order) {
        return this.iOrderRepository.save(order);
    }

    /**
     * Retrieves all existing orders.
     *
     * @return An iterable containing all orders.
     */
    public Iterable<Order> findAll() {
        return this.iOrderRepository.findAll();
    }

    /**
     * Retrieves all orders associated with a specific user.
     *
     * @param userId The ID of the user.
     * @return An iterable containing the orders of the user.
     */
    public Iterable<Order> fingByUserId(Integer userId) {
        return this.iOrderRepository.findByUserId(userId);
    }

    /**
     * Updates the state of an existing order identified by its ID.
     *
     * @param id    The ID of the order to update.
     * @param state The new state to be applied.
     */
    public void updateStateById(Integer id, String state) {
        this.iOrderRepository.updateStateById(id, state);
    }

    /**
     * Retrieves an order by its ID.
     *
     * @param id The ID of the order.
     * @return The order found, or null if it does not exist.
     */
    public Order findById(Integer id) {
        return this.iOrderRepository.findById(id);
    }

}
