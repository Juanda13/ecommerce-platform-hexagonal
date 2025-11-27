package com.juanlopez.ecommerce.backend.application;

import com.juanlopez.ecommerce.backend.domain.model.User;
import com.juanlopez.ecommerce.backend.domain.port.IUserRepository;

/**
 * Application service for managing {@link User} operations.
 * <p>
 * this service acts as an intermediary between the domain layer and
 * the infrastructure layer, delegating persistence operations to
 * {@link IUserRepository}. It exposes the application-level uses cases
 * related to user management.
 */
public class UserService {

    private final IUserRepository iUserRepository;

    /**
     * Creates a new instance of {@code UserService}.
     *
     * @param iUserRepository the repository used for user persistence operations
     */
    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    /**
     * Saves a new user or updates an existing one.
     *
     * @param user the user to save
     * @return the persisted user
     */
    public User save(User user) {
        return this.iUserRepository.save(user);
    }

    /**
     * Finds a user by its ID.
     *
     * @param id the user ID
     * @return the user if found
     * @throws RuntimeException if the user does not exist (as implemented by the repository)
     */
    public User findById(Integer id) {
        return this.iUserRepository.findById(id);
    }

}
