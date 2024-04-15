package org.simexmax.adapters.driven.mongodb.entities.person;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Getter
@Builder
public class IdentificationTypeEntity {
    /**
     *  Identification type ID
     */
    @MongoId
    private String ID;
    /**
     * The name of the identification type.
     */
    private String name;
    /**
     * A description of the identification type.
     */
    private String description;
    /**
     * The initials or abbreviation of the identification type.
     */
    private String initials;
}

