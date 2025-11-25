package com.juanlopez.ecommerce.backend.domain.model;

/**
 * Enum representing the type or role of a user in the e-commerce platform.
 * <p>
 * Defines the different levels of access and permissions a user can have:
 * <ul>
 *     <li>{@code ADMIN} - User with administrative privileges, can manage products, categories, and users.</li>
 *     <li>{@code USER} - Regular user with standard permissions, primarily for browsing and purchasing products.</li>
 * </ul>
 */
public enum UserType {
    ADMIN, USER
}
