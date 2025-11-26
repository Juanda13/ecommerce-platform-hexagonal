package com.juanlopez.ecommerce.backend.infrastructure.rest;

import com.juanlopez.ecommerce.backend.application.UserService;
import com.juanlopez.ecommerce.backend.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing {@link User} resources.
 * <p>
 * Provides endpoints to create and retrieve users.
 * Delegates business logic to {@link UserService}.
 */
@RestController
@RequestMapping("/api/v1/users")
@Slf4j
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
     * Creates a new user.
     *
     * @param user the user to persist
     * @return a {@link ResponseEntity} containing the persisted user with HTTP 201 status
     */
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    /**
     * Retrieves a user by its ID.
     *
     * @param id the ID of the user to retrieve
     * @return a {@link ResponseEntity} containing the user with HTTP 200 status
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

}
