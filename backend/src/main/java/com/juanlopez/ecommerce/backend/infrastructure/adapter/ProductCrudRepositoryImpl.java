package com.juanlopez.ecommerce.backend.infrastructure.adapter;

import com.juanlopez.ecommerce.backend.domain.model.Product;
import com.juanlopez.ecommerce.backend.domain.port.IProductRepository;
import com.juanlopez.ecommerce.backend.infrastructure.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

/**
 * Infrastructure adapter that implements the domain {@link IProductRepository} port.
 * <p>
 * Acts as a bridge between the domain layer and the underlying persistence mechanism.
 * Uses Spring Data's {@link IProductCrudRepository} for database operations and
 * {@link ProductMapper} to map between domain models and JPA entities, ensuring a clear
 * separation of concerns in alignment with the hexagonal architecture.
 * <p>
 * This class is registered as a Spring {@code @Repository} component.
 */
@Repository
public class ProductCrudRepositoryImpl implements IProductRepository {

    private final IProductCrudRepository iProductCrudRepository;
    private final ProductMapper productMapper;

    /**
     * Constructs a new repository implementation.
     *
     * @param iProductCrudRepository the Spring Data CRUD repository for products
     * @param productMapper the mapper responsible for converting between domain and entity models
     */
    public ProductCrudRepositoryImpl(IProductCrudRepository iProductCrudRepository, ProductMapper productMapper) {
        this.iProductCrudRepository = iProductCrudRepository;
        this.productMapper = productMapper;
    }

    /**
     * Saves a domain {@link Product} into the database.
     * <p>
     * The product is first converted into a {@link com.juanlopez.ecommerce.backend.infrastructure.entity.ProductEntity},
     * persisted using the Spring Data repository, and then mapped back to its domain representation.
     *
     * @param product the domain product to save
     * @return the saved product mapped back to the domain model
     */
    @Override
    public Product save(Product product) {
        return productMapper.toProduct(iProductCrudRepository.save(productMapper.toProductEntity(product)));
    }

    /**
     * Retrieves all products stored in the database.
     *
     * @return an iterable collection of domain {@link Product} objects
     */
    @Override
    public Iterable<Product> findAll() {
        return productMapper.toProducts(iProductCrudRepository.findAll());
    }

    /**
     * Finds a product by its unique identifier.
     * <p>
     * If the product does not exist, a {@link RuntimeException} is thrown.
     *
     * @param id the identifier of the product
     * @return the corresponding domain {@link Product}
     * @throws RuntimeException if no product exists with the given id
     */
    @Override
    public Product findById(Integer id) {
        return productMapper.toProduct(iProductCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Producto con Id:" + id + " no existe.")
        ));
    }

    /**
     * Deletes a product by its unique identifier.
     * <p>
     * Before deletion, the method verifies that the product exists in the database.
     * If no product is found with the given ID, a {@link RuntimeException} is thrown.
     *
     * @param id the identifier of the product to delete
     * @throws RuntimeException if the product does not exist
     */
    @Override
    public void deleteById(Integer id) {
        // Validate that the product exists before deleting
        iProductCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Producto con Id:" + id + " no existe.")
        );
        iProductCrudRepository.deleteById(id);
    }
}
