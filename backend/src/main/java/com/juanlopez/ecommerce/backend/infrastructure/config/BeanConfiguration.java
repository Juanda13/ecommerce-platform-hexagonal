package com.juanlopez.ecommerce.backend.infrastructure.config;

import com.juanlopez.ecommerce.backend.application.UserService;
import com.juanlopez.ecommerce.backend.domain.port.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration class for defining application beans.
 * <p>
 * This class is part of the infrastructure layer and provides
 * bean definitions for dependency injection.
 */
@Configuration
public class BeanConfiguration {

    /**
     * Defines a {@link UserService} bean.
     * <p>
     * Injects an implementation of {@link IUserRepository} into the service.
     *
     * @param iUserRepository the repository to be injected into the service
     * @return a new instance of {@link UserService}
     */
    @Bean
    public UserService userService(IUserRepository iUserRepository) {
        return new UserService(iUserRepository);
    }

}
