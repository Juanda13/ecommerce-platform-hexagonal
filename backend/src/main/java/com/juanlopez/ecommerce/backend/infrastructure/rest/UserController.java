package com.juanlopez.ecommerce.backend.infrastructure.rest;

import com.juanlopez.ecommerce.backend.application.UserService;
import com.juanlopez.ecommerce.backend.domain.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing {@link User} resources.
 * <p>
 * Provides endpoints to create and retrieve users.
 * Delegates business logic to {@link UserService}.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructs a new {@code UserController} with the given {@link UserService}.
     *
     * @param userService the service responsible for user operations
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Creates a new user or updates an existing one.
     *
     * @param user the user to create or update
     * @return the created or updated user
     */
    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * Retrieves a user by its ID.
     *
     * @param id the ID of the user
     * @return the user with the given ID
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

}
