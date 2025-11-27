package com.juanlopez.ecommerce.backend.domain.port;

import com.juanlopez.ecommerce.backend.domain.model.User;

/**
 * Repository interface for managing {@link User} persistence operations.
 * <p>
 * This interface defines the contract for storing, retrieving, and querying users.
 * Implementations of this interface reside in the infrastructure layer.
 */
public interface IUserRepository {

    /**
     * Saves a new user or updates an existing one.
     *
     * @param user the user to save
     * @return the persisted user
     */
    User save(User user);

    /**
     * Finds a user by their email address.
     *
     * @param email the email of the user
     * @return the user if found
     * @throws RuntimeException if no user with the given email exists (implementation-specific)
     */
    User findByEmail(String email);

    /**
     * Finds a user by their ID.
     *
     * @param id the user ID
     * @return the user if found
     * @throws RuntimeException if the user does not exist (implementation-specific)
     */
    User findById(Integer id);

}
