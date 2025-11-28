package com.juanlopez.ecommerce.backend.infrastructure.adapter;

import com.juanlopez.ecommerce.backend.domain.model.Order;
import com.juanlopez.ecommerce.backend.domain.model.OrderState;
import com.juanlopez.ecommerce.backend.domain.port.IOrderRepository;
import com.juanlopez.ecommerce.backend.infrastructure.entity.OrderEntity;
import com.juanlopez.ecommerce.backend.infrastructure.entity.UserEntity;
import com.juanlopez.ecommerce.backend.infrastructure.mapper.IOrderMapper;
import org.springframework.stereotype.Repository;

/**
 * Infrastructure adapter implementing the {@link IOrderRepository} port using
 * Spring Data JPA as the persistence mechanism.
 * <p>
 * This class acts as the concrete bridge between the domain layer and the database.
 * It uses MapStruct mappers to convert between domain models and JPA entities,
 * ensuring that the domain remains decoupled from persistence concerns.
 */
@Repository
public class OrderCrudRepositoryImpl implements IOrderRepository {

    private final IOrderMapper iOrderMapper;
    private final IOrderCrudRepository iOrderCrudRepository;

    /**
     * Constructs the repository adapter with its required dependencies.
     *
     * @param iOrderMapper          Mapper responsible for converting between domain and entity objects.
     * @param iOrderCrudRepository  Spring Data JPA repository for order entities.
     */
    public OrderCrudRepositoryImpl(IOrderMapper iOrderMapper, IOrderCrudRepository iOrderCrudRepository) {
        this.iOrderMapper = iOrderMapper;
        this.iOrderCrudRepository = iOrderCrudRepository;
    }

    /**
     * Persists a new order or updates an existing one.
     * <p>
     * Before saving, this method assigns the parent {@link OrderEntity} reference
     * to each contained {@code OrderProductEntity}, ensuring proper bidirectional
     * relationship handling by JPA.
     *
     * @param order Domain model to be saved.
     * @return The persisted order mapped back to its domain representation.
     */
    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = iOrderMapper.toOrderEntity(order);

        // Set bidirectional relationship for JPA
        orderEntity.getOrderProducts().forEach(
                orderProductEntity -> orderProductEntity.setOrderEntity(orderEntity)
        );

        return iOrderMapper.toOrder(iOrderCrudRepository.save(orderEntity));
    }

    /**
     * Retrieves an order by its identifier.
     *
     * @param id The ID of the order to fetch.
     * @return The corresponding domain order.
     * @throws RuntimeException If no order exists with the given ID.
     */
    @Override
    public Order findById(Integer id) {
        return iOrderMapper.toOrder(iOrderCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Orden con Id: " + " no existe.")
        ));
    }

    /**
     * Retrieves all orders stored in the system.
     *
     * @return An iterable collection of domain orders.
     */
    @Override
    public Iterable<Order> findAll() {
        return iOrderMapper.toOrders(iOrderCrudRepository.findAll());
    }

    /**
     * Retrieves all orders associated with a specific user.
     * <p>
     * A lightweight {@link UserEntity} instance is created containing only the ID,
     * allowing Spring Data JPA to perform the lookup without loading the full entity.
     *
     * @param userId The ID of the user whose orders are to be retrieved.
     * @return Iterable collection of domain orders for the user.
     */
    @Override
    public Iterable<Order> findByUserId(Integer userId) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        return iOrderMapper.toOrders(iOrderCrudRepository.findByUserEntity(userEntity));
    }

    /**
     * Updates the processing state of an order.
     * <p>
     * The provided string is converted to the corresponding {@link OrderState}
     * enum before delegating the update to the underlying JPA repository.
     *
     * @param id    The ID of the order to update.
     * @param state The new state as a string matching the {@link OrderState} values.
     */
    @Override
    public void updateStateById(Integer id, String state) {
        OrderState orderState = OrderState.valueOf(state);
        iOrderCrudRepository.updateStateById(id, orderState);
    }
}
