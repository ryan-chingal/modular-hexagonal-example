package org.simexmax.dto.person;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Getter
@SuperBuilder
public abstract class APersonDto {

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
    protected String identification;
    /**
     * APerson initials or abbreviation of the identification type.
     */
    protected String identificationInitials;
    /**
     * APerson name of the identification type.
     */
    protected String identificationType;
    /**
     * APerson description of the identification type.
     */
    private String identificationDescription;
    /**
     * APerson birthdate
     */
    protected Long birthDate;
}
