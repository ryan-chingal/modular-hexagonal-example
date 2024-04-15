package org.simexmax.adapters.driver.rest.exeptions;

import lombok.Getter;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Getter
public class ElementNotFoundException  extends RuntimeException {
    private final int code;
    private final String message;
    public ElementNotFoundException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}