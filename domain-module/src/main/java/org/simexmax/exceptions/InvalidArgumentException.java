package org.simexmax.exceptions;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@neotropic.co>
 */
public class InvalidArgumentException extends RuntimeException {
    private final int code;
    private final String message;
    public InvalidArgumentException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage(){
        return message;
    }
}
