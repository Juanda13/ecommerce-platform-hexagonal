package com.juanlopez.ecommerce.backend.application;

import com.juanlopez.ecommerce.backend.domain.model.Product;
import com.juanlopez.ecommerce.backend.domain.port.IProductRepository;

/**
 * Application service for managing {@link Product} operations.
 * <p>
 * This service acts as an intermediary between the domain layer and
 * the infrastructure layer, delegating persistence operations to
 * {@link IProductRepository}. It contains the application use cases
 * related to product management.
 */
public class ProductService {

    private final IProductRepository iProductRepository;

    /**
     * creates a new instance of {@code ProductService}.
     *
     * @param iProductRepository the repository used for product persistence operations
     */
    public ProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    /**
     * Saves a new product or updates an existing one.
     *
     * @param product the product to save
     * @return the persisted product
     */
    public Product save(Product product) {
        return this.iProductRepository.save(product);
    }

    /**
     * Retrieves all products.
     *
     * @return an iterable collection of products
     */
    public Iterable<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    /**
     * Finds a product by its ID.
     *
     * @param id the product ID.
     * @return the product if found
     * @throws RuntimeException if the product does not exist (as implemented by the repository)
     */
    public Product findById(Integer id) {
        return this.iProductRepository.findById(id);
    }

    /**
     * Deletes a product by its ID.
     * <p>
     * This method delegates the deletion to the repository. If the product
     * does not exist, the repository implementation determines the behavior.
     */
    public void deleteById(Integer id) {
        this.iProductRepository.deleteById(id);
    }

}
