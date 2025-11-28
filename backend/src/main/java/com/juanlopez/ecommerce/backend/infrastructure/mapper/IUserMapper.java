package com.juanlopez.ecommerce.backend.infrastructure.mapper;

import com.juanlopez.ecommerce.backend.domain.model.User;
import com.juanlopez.ecommerce.backend.infrastructure.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between {@link User} domain models
 * and {@link UserEntity} persistence entities.
 * <p>
 * Uses MapStruct to automatically generate the implementation.
 * This mapper is part of the infrastructure layer and is injected
 * as a Spring component.
 */
@Mapper(componentModel = "spring")
public interface IUserMapper {

    /**
     * Converts a {@link UserEntity} to a {@link User} domain model.
     *
     * @param userEntity the entity to convert
     * @return the corresponding domain model
     */
    User toUser(UserEntity userEntity);

    /**
     * Converts an iterable collection of {@link UserEntity} objects
     * to an iterable collection of {@link User} domain models.
     *
     * @param userEntities the entities to convert
     * @return an iterable of corresponding domain models
     */
    Iterable<User> toUsers(Iterable<UserEntity> userEntities);

    /**
     * Converts a {@link User} domain model to a {@link UserEntity}.
     * <p>
     * Inherits mapping configuration from {@link #toUser(UserEntity)}.
     *
     * @param user the domain model to convert
     * @return the corresponding persistence entity
     */
    @InheritInverseConfiguration
    UserEntity toUserEntity(User user);

}
