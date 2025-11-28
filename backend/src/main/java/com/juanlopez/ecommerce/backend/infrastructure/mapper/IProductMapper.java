package com.juanlopez.ecommerce.backend.infrastructure.mapper;

import com.juanlopez.ecommerce.backend.domain.model.Product;
import com.juanlopez.ecommerce.backend.infrastructure.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * MapStruct mapper for converting between domain {@link Product} objects
 * and infrastructure {@link ProductEntity} JPA entities.
 * <p>
 * This interface is part of the infrastructure layer and defines the mapping
 * logic used by MapStruct to translate data between the domain model and the
 * persistence representation, ensuring separation of concerns within the
 * architecture.
 * <p>
 * The mapper is registered as a Spring bean through {@code componentModel = "spring"}.
 */
@Mapper(componentModel = "spring")
public interface IProductMapper {

    /**
     * Converts a {@link ProductEntity} into a domain {@link Product}.
     * <p>
     * Maps the nested {@code userEntity.id} and {@code categoryEntity.id}
     * into the corresponding domain identifiers.
     *
     * @param productEntity the JPA entity to convert
     * @return the corresponding domain model representation
     */
    @Mapping(source = "userEntity.id", target = "userId")
    @Mapping(source = "categoryEntity.id", target = "categoryId")
    Product toProduct(ProductEntity productEntity);

    /**
     * Converts a collection of {@link ProductEntity} into domain {@link Product} objects.
     *
     * @param productEntities the list or iterable of product entities
     * @return an iterable with the mapped domain models
     */
    Iterable<Product> toProducts(Iterable<ProductEntity> productEntities);

    /**
     * Converts a domain {@link Product} into a {@link ProductEntity}.
     * <p>
     * Uses MapStruct's {@link InheritInverseConfiguration} to apply the
     * inverse mapping rules defined in {@link #toProduct(ProductEntity)}.
     *
     * @param product the domain model to convert
     * @return the corresponding JPA entity representation
     */
    @InheritInverseConfiguration
    ProductEntity toProductEntity(Product product);

}
