package org.simexmax.adapters.driven.mongodb.entities.person;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * Represents an identification document.
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Document("identifications")
@Getter
@Builder
public class IdentificationEntity {
    /**
     * Identification ID
     */
    @MongoId
    private String ID;
    /**
     * Type of identification
     */
    private IdentificationTypeEntity type;
    /**
     * Identification number.
     */
    private String number;
    /**
     * Date when this identification was issued.
     */
    private Long issueDate;
    /**
     * Date when this identification became valid (optional).
     */
    private Long validFromDate;
    /**
     * Date when this identification expired (optional).
     */
    private Long expirationDate;
    /**
     * Indicates if it's currently active
     */
    private Boolean isActive;
}
