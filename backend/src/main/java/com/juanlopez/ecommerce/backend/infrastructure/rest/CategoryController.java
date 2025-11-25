package com.juanlopez.ecommerce.backend.infrastructure.rest;

import com.juanlopez.ecommerce.backend.application.CategoryService;
import com.juanlopez.ecommerce.backend.domain.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing {@link Category} resources.
 * <p>
 * Provides endpoints to create, retrieve, and delete categories.
 * Delegates business logic to {@link CategoryService}.
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
     * @param category the category to create or update
     * @return the created or updated category
     */
    @PostMapping
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    /**
     * Retrieves all categories.
     *
     * @return an iterable of all categories
     */
    @GetMapping
    public Iterable<Category> findAll() {
        return categoryService.findAll();
    }

    /**
     * Retrieves a category by its ID.
     *
     * @param id the ID of the category
     * @return the category with the given ID
     */
    @GetMapping("/{id}")
    public Category findById(@PathVariable Integer id) {
        return categoryService.findById(id);
    }

    /**
     * Deletes a category by its ID.
     *
     * @param id the ID of the category to delete
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        categoryService.deleteById(id);
    }

}
