package com.juanlopez.ecommerce.backend.infrastructure.rest;

import com.juanlopez.ecommerce.backend.application.OrderService;
import com.juanlopez.ecommerce.backend.domain.model.Order;
import com.juanlopez.ecommerce.backend.domain.model.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing orders.
 * <p>
 * This controller provides endpoints for creating, updating, and retrieving orders.
 * It acts as the entry point for HTTP requests related to order operations, delegating
 * the business logic to {@link OrderService}.
 */
@RestController
@RequestMapping("api/v1/orders")
@Slf4j
public class OrderController {

    private final OrderService orderService;

    /**
     * Constructs the OrderController with the given OrderService.
     *
     * @param orderService The service handling order-related business logic.
     */
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Creates a new order.
     * <p>
     * The order state is automatically set to CONFIRMED unless the incoming order
     * is marked as CANCELLED.
     *
     * @param order The order to create.
     * @return The created order with its assigned state.
     */
    @PostMapping
    public ResponseEntity<Order> save(@RequestBody Order order) {
        if (order.getOrderState().toString().equals(OrderState.CANCELLED.toString())) {
            order.setOrderState(OrderState.CANCELLED);
        } else {
            order.setOrderState(OrderState.CONFIRMED);
        }
        return ResponseEntity.ok(orderService.save(order));
    }

    /**
     * Updates the state of an existing order identified by its ID.
     *
     * @param id    The ID of the order to update.
     * @param state The new state to be applied.
     * @return A response entity with no content.
     */
    @PostMapping("/update/state/order")
    public ResponseEntity<Void> updateStateById(@RequestParam Integer id, @RequestParam String state) {
        orderService.updateStateById(id, state);
        return ResponseEntity.ok().build();
    }

    /**
     * Retrieves all existing orders.
     *
     * @return An iterable collection of orders.
     */
    @GetMapping
    public ResponseEntity<Iterable<Order>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    /**
     * Retrieves a specific order by its ID.
     *
     * @param id The ID of the order.
     * @return The order corresponding to the given ID.
     */
    @GetMapping("{variable}")
    public ResponseEntity<Order> findById(@PathVariable("variable") Integer id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    /**
     * Retrieves all orders associated with a specific user.
     *
     * @param userId The ID of the user.
     * @return An iterable collection of orders for the given user.
     */
    @GetMapping("/by-user/{id}")
    public ResponseEntity<Iterable<Order>> findByUserId(@PathVariable("id") Integer userId) {
        return ResponseEntity.ok(orderService.fingByUserId(userId));
    }

}
