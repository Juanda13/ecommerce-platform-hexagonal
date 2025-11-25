package com.juanlopez.ecommerce.backend.domain.port;

import com.juanlopez.ecommerce.backend.domain.model.Product;

/**
 * Repository interface for managing {@link Product} persistence operations.
 * <p>
 * This interface defines the contract for storing, retrieving, and deleting products.
 * Implementations of this interface reside in the infrastructure layer.
 */
public interface IProductRepository {

    /**
     * Saves a new product or updates an existing one.
     *
     * @param product the product to save
     * @return the persisted product
     */
    Product save(Product product);

    /**
     * Retrieves all products.
     *
     * @return an iterable collection of products
     */
    Iterable<Product> findAll();

    /**
     * Finds a product by its ID.
     *
     * @param id the product ID
     * @return the product if found
     * @throws RuntimeException if the product does not exist (implementation-specific)
     */
    Product findById(Integer id);

    /**
     * Deletes a product by its ID.
     * <p>
     * This method is implemented in the infrastructure layer.
     *
     * @param id the ID of the product to delete
     */
    void deleteById(Integer id);

}
