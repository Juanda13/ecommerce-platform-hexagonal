package com.juanlopez.ecommerce.backend.infrastructure.rest;

import com.juanlopez.ecommerce.backend.application.CategoryService;
import com.juanlopez.ecommerce.backend.domain.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing {@link Category} resources.
 * <p>
 * Provides endpoints to create, retrieve, and delete categories.
 * Uses {@link CategoryService} to handle business logic.
 */
@RestController
@RequestMapping("api/v1/admin/categories")
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    /**
     * Constructs a new {@code CategoryController} with the given {@link CategoryService}.
     *
     * @param categoryService the service responsible for category operations
     */
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Creates a new category or updates an existing one.
     *
     * @param category the category data to create or update
     * @return a {@link ResponseEntity} with the persisted category and HTTP 201 status
     */
    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    /**
     * Retrieves all categories.
     *
     * @return a {@link ResponseEntity} containing the list of categories with HTTP 200 status
     */
    @GetMapping
    public ResponseEntity<Iterable<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    /**
     * Retrieves a category by its ID.
     *
     * @param id the ID of the category to fetch
     * @return a {@link ResponseEntity} containing the category with HTTP 200 status
     */
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    /**
     * Deletes a category by its ID.
     *
     * @param id the ID of the category to delete
     * @return a {@link ResponseEntity} with HTTP 200 status upon successful deletion
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
