package com.juanlopez.ecommerce.backend.infrastructure.mapper;

import com.juanlopez.ecommerce.backend.domain.model.OrderProduct;
import com.juanlopez.ecommerce.backend.infrastructure.entity.OrderProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * MapStruct mapper responsible for converting between the domain model
 * {@link OrderProduct} and the JPA entity {@link OrderProductEntity}.
 * <p>
 * As part of the infrastructure layer, this mapper facilitates communication
 * between domain logic and persistence mechanisms while ensuring that both
 * models remain isolated and independent. MapStruct generates the underlying
 * implementation at compile time.
 */
@Mapper(componentModel = "spring")
public interface IOrderProductMapper {

    /**
     * Converts a JPA {@link OrderProductEntity} into its corresponding
     * domain {@link OrderProduct} representation.
     *
     * @param orderProductEntity The persistence entity to convert.
     * @return The mapped domain model instance.
     */
    OrderProduct toOrderProduct(OrderProductEntity orderProductEntity);

    /**
     * Converts an iterable collection of {@link OrderProductEntity} objects
     * into their domain model counterparts.
     *
     * @param orderProductEntities Iterable of persistence entities.
     * @return Iterable of mapped domain model objects.
     */
    Iterable<OrderProduct> toOrderProducts(Iterable<OrderProductEntity> orderProductEntities);

    /**
     * Converts a domain {@link OrderProduct} back into its corresponding
     * persistence {@link OrderProductEntity}.
     * <p>
     * The mapping configuration is inherited from {@link #toOrderProduct(OrderProductEntity)}
     * to ensure consistency between bidirectional transformations.
     *
     * @param orderProduct The domain model instance to convert.
     * @return The mapped JPA entity.
     */
    @InheritInverseConfiguration
    OrderProductEntity toOrderProductEntity(OrderProduct orderProduct);

}
