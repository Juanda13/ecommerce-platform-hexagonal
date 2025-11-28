package com.juanlopez.ecommerce.backend.domain.port;

import com.juanlopez.ecommerce.backend.domain.model.Order;

/**
 * Domain port defining the contract for interacting with the order persistence mechanism.
 * <p>
 * This interface serves as an abstraction between the domain layer and the underlying
 * infrastructure (e.g., database, external services). Implementations of this port must
 * reside within the infrastructure layer, ensuring that the domain remains independent
 * from technical details.
 */
public interface IOrderRepository {

    /**
     * Persists a new order or updates an existing one.
     *
     * @param order The domain order instance to be saved.
     * @return The persisted order, potentially containing updated values such as a
     *         generated identifier.
     */
    Order save(Order order);

    /**
     * Retrieves an order by its unique identifier.
     *
     * @param id The identifier of the order to fetch.
     * @return The corresponding {@link Order} if found, or {@code null} if it does not exist.
     */
    Order findById(Integer id);

    /**
     * Retrieves all orders stored in the system.
     *
     * @return An iterable collection containing all orders.
     */
    Iterable<Order> findAll();

    /**
     * Retrieves all orders associated with a specific user.
     *
     * @param userId The identifier of the user whose orders are to be fetched.
     * @return An iterable collection of the user's orders.
     */
    Iterable<Order> findByUserId(Integer userId);

    /**
     * Updates the state of an order identified by its ID.
     *
     * @param id    The identifier of the order to update.
     * @param state The new state to be applied to the order.
     */
    void updateStateById(Integer id, String state);

}
