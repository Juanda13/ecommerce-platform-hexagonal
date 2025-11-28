package com.juanlopez.ecommerce.backend.infrastructure.mapper;

import com.juanlopez.ecommerce.backend.domain.model.Order;
import com.juanlopez.ecommerce.backend.infrastructure.entity.OrderEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * MapStruct mapper responsible for converting between the domain model
 * {@link Order} and the JPA entity {@link OrderEntity}.
 * <p>
 * This mapper belongs to the infrastructure layer and serves as a bridge
 * between the domain and persistence representations of an order. It relies
 * on {@link IOrderProductMapper} to map nested order-product elements,
 * ensuring that conversions remain consistent across the entire structure.
 */
@Mapper(componentModel = "spring", uses = IOrderProductMapper.class)
public interface IOrderMapper {

    /**
     * Converts an {@link OrderEntity} into its corresponding domain {@link Order}.
     * <p>
     * The mapping explicitly extracts the user ID from the associated
     * {@code UserEntity}, ensuring that the domain model remains independent
     * from infrastructure-level relationships.
     *
     * @param orderEntity The JPA entity to convert.
     * @return The mapped domain order instance.
     */
    @Mapping(source = "userEntity.id", target = "userId")
    Order toOrder(OrderEntity orderEntity);

    /**
     * Converts an iterable collection of {@link OrderEntity} objects into
     * a corresponding iterable collection of domain {@link Order} instances.
     *
     * @param orderEntities Iterable of persistence entities.
     * @return Iterable of mapped domain objects.
     */
    Iterable<Order> toOrders(Iterable<OrderEntity> orderEntities);

    /**
     * Converts a domain {@link Order} back into its corresponding
     * persistence {@link OrderEntity}.
     * <p>
     * The configuration is inherited from {@link #toOrder(OrderEntity)}
     * to ensure consistent bidirectional mapping. Nested product mappings
     * are delegated to {@link IOrderProductMapper}.
     *
     * @param order The domain model instance to convert.
     * @return The mapped JPA entity.
     */
    @InheritInverseConfiguration
    OrderEntity toOrderEntity(Order order);

}
