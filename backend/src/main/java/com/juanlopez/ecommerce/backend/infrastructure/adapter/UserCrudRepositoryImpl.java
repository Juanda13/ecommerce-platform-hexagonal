package com.juanlopez.ecommerce.backend.infrastructure.adapter;

import com.juanlopez.ecommerce.backend.domain.model.User;
import com.juanlopez.ecommerce.backend.domain.port.IUserRepository;
import com.juanlopez.ecommerce.backend.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * Implementation of {@link IUserRepository} using Spring Data JPA.
 * <p>
 * Acts as an adapter between the domain layer and the persistence layer.
 * Handles CRUD operations for {@link User} entities and maps them
 * between domain and database representations using {@link UserMapper}.
 */
@Repository
public class UserCrudRepositoryImpl implements IUserRepository {

    private final IUserCrudRepository iUserCrudRepository;
    private final UserMapper userMapper;

    /**
     * Constructs a new {@code UserCrudRepositoryImpl} with the given
     * JPA repository and mapper.
     *
     * @param iUserCrudRepository the Spring Data repository for User entities
     * @param userMapper the mapper to convert between domain and entity objects
     */
    public UserCrudRepositoryImpl(IUserCrudRepository iUserCrudRepository, UserMapper userMapper) {
        this.iUserCrudRepository = iUserCrudRepository;
        this.userMapper = userMapper;
    }

    /**
     * Saves a new user or updates an existing one.
     *
     * @param user the user to save
     * @return the persisted user mapped back to the domain model
     */
    @Override
    public User save(User user) {
        return userMapper.toUser(iUserCrudRepository.save(userMapper.toUserEntity(user)));
    }

    /**
     * Finds a user by their email address.
     * <p>
     * This method is currently not implemented and returns {@code null}.
     * Implementing this method is necessary for login or email-based queries.
     *
     * @param email the email of the user
     * @return the user if found (currently always {@code null})
     */
    @Override
    public User findByEmail(String email) {
        return null;
    }

    /**
     * Finds a user by their ID.
     *
     * @param id the user ID
     * @return the user if found
     * @throws RuntimeException if the user does not exist
     */
    @Override
    public User findById(Integer id) {
        return userMapper.toUser(iUserCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El usuario con id: " + id + " no existe.")
        ));
    }
}
