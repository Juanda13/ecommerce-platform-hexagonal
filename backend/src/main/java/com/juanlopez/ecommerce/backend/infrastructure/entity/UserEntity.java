package com.juanlopez.ecommerce.backend.infrastructure.entity;

import com.juanlopez.ecommerce.backend.domain.model.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * JPA entity representing a user in the database.
 * <p>
 * Maps to the {@code users} table and contains fields for user identity,
 * contact, authentication, role, and auditing information.
 * This class is part of the infrastructure layer and is used
 * by Spring Data JPA for persistence operations.
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {

    /**
     * Primary key of the user.
     * <p>
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Username used for authentication.
     */
    private String username;

    /**
     * First name of the user.
     */
    private String firstName;

    /**
     * Last name of the user.
     */
    private String lastName;

    /**
     * Email of the user.
     * <p>
     * Must be unique across all users.
     */
    @Column(unique = true)
    private String email;

    /**
     * Physical address of the user.
     */
    private String address;

    /**
     * Cellphone number of the user.
     */
    private String cellphone;

    /**
     * Encrypted password of the user.
     */
    private String password;

    /**
     * Role or type of the user.
     * <p>
     * Stored as a string in the database.
     */
    @Enumerated(EnumType.STRING)
    private UserType userType;

    /**
     * Timestamp of when the user was created.
     * <p>
     * Automatically set by Hibernate on creation.
     */
    @CreationTimestamp
    private LocalDateTime dateCreated;

    /**
     * Timestamp of when the user was last updated.
     * <p>
     * Automatically updated by Hibernate on modification.
     */
    @UpdateTimestamp
    private LocalDateTime dateUpdated;

}
