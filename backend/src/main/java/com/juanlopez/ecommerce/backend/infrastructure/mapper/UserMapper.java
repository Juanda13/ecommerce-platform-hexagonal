package com.juanlopez.ecommerce.backend.infrastructure.mapper;

import com.juanlopez.ecommerce.backend.domain.model.User;
import com.juanlopez.ecommerce.backend.infrastructure.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserEntity userEntity);
    Iterable<User> toUsers(Iterable<UserEntity> userEntities);

    @InheritInverseConfiguration
    UserEntity toUserEntity(User user);

}
