package com.juanlopez.ecommerce.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Domain model representing a user within the e-commerce platform.
 * <p>
 * A user contains identification, contact, authentication, and auditing
 * information. This model is part of the domain layer and must remain
 * independent of infrastructure-specific concerns.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * Unique identifier of the user.
     */
    private Integer id;

    /**
     * Username used for authentication and identification in the system.
     */
    private String username;

    /**
     * The user's first name.
     */
    private String firstName;

    /**
     * The user's last name.
     */
    private String lastName;

    /**
     * Email used for communication and notifications.
     */
    private String email;

    /**
     * Physical address associated with the user.
     */
    private String address;

    /**
     * Cellphone number used for communication or verification.
     */
    private String cellphone;

    /**
     * Encrypted password of the user.
     * <p>
     * This field should always contain a hashed value and never raw text.
     */
    private String password;

    /**
     * Type or role of the user within the system.
     */
    private UserType userType;

    /**
     * Date and time when the user was created.
     */
    private LocalDateTime dateCreated;

    /**
     * Date and time when the user information was last updated.
     */
    private LocalDateTime dateUpdated;

}
