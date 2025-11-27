package com.juanlopez.ecommerce.backend.infrastructure.rest;

import com.juanlopez.ecommerce.backend.application.ProductService;
import com.juanlopez.ecommerce.backend.domain.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing products through the administrative API.
 * <p>
 * Exposes endpoints for creating, retrieving, and deleting products. This
 * controller belongs to the infrastructure layer and delegates business
 * operations to the {@link ProductService}, maintaining consistency with the
 * hexagonal architecture by keeping the controller free of domain logic.
 */
@RestController
@RequestMapping("api/v1/admin/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    /**
     * Constructs a new {@link ProductController}.
     *
     * @param productService the application service that handles product operations
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Saves a new product.
     * <p>
     * Logs the product name for debugging/auditing purposes and delegates
     * the save operation to the {@link ProductService}.
     *
     * @param product the product to be created
     * @return a {@link ResponseEntity} containing the created product and {@code 201 CREATED} status
     */
    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        log.info("Nombre producto: {}", product.getName());
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    /**
     * Retrieves all products.
     *
     * @return a {@link ResponseEntity} containing all registered products with {@code 200 OK} status
     */
    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    /**
     * Retrieves a product by its unique identifier.
     *
     * @param id the identifier of the product to retrieve
     * @return a {@link ResponseEntity} containing the product with {@code 200 OK} status
     * @throws RuntimeException if no product exists with the provided id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    /**
     * Deletes a product by its unique identifier.
     * <p>
     * The deletion is performed by the {@link ProductService}.
     *
     * @param id the identifier of the product to delete
     * @return a {@link ResponseEntity} with {@code 200 OK} status once deletion is complete
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
