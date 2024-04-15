package org.simexmax.adapters.driven.mongodb.entities.person;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Getter
@SuperBuilder
public abstract class APersonEntity {
    /**
     * APerson ID
     */
    @MongoId
    protected String ID;
    /**
     * APerson ANme for login usage
     */
    protected String userName;
    /**
     * APerson first name
     */
    protected String firstName;
    /**
     * APerson second name
     */
    protected String secondName;
    /**
     * APerson first lastname
     */
    protected String firstLastname;
    /**
     * APerson second lastname
     */
    protected String secondLastname;
    /**
     * APerson e-mail
     */
    protected String email;
    /**
     * APerson password
     */
    protected String password;
    /**
     * APerson identification
     */
    protected List<IdentificationEntity> identificationList;
    /**
     * APerson birthdate
     */
    protected Long birthDate;
}
