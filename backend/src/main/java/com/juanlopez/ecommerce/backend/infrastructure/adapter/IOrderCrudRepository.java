package com.juanlopez.ecommerce.backend.infrastructure.adapter;

import com.juanlopez.ecommerce.backend.domain.model.OrderState;
import com.juanlopez.ecommerce.backend.infrastructure.entity.OrderEntity;
import com.juanlopez.ecommerce.backend.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring Data JPA repository for performing CRUD and custom operations
 * on {@link OrderEntity} instances.
 * <p>
 * This interface belongs to the infrastructure layer, providing a concrete
 * persistence mechanism for order records. It acts as the low-level adapter
 * that satisfies the requirements of the domain port responsible for order
 * persistence. Custom queries and transactional behavior are implemented
 * following Spring Data best practices.
 */
public interface IOrderCrudRepository extends CrudRepository<OrderEntity, Integer> {

    /**
     * Updates the state of an existing order identified by its ID.
     * <p>
     * This method uses a JPQL update query to modify only the specific
     * state field without requiring a full entity merge. The operation
     * runs inside a transactional context and is marked as modifying.
     *
     * @param id    The identifier of the order to update.
     * @param state The new {@link OrderState} to be applied.
     */
    @Transactional
    @Modifying
    @Query("UPDATE OrderEntity o SET o.state = : state WHERE o.id = :id")
    void updateStateById(Integer id, OrderState state);

    /**
     * Retrieves all orders associated with the given user entity.
     *
     * @param userEntity The user whose orders are to be returned.
     * @return An iterable collection of orders owned by the user.
     */
    Iterable<OrderEntity> findByUserEntity(UserEntity userEntity);

}
