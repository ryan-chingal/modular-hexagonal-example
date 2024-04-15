package org.simexmax.adapters.driver.rest.advices;

import org.simexmax.exceptions.ElementNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ElementNotFoundException> handleElementNotFoundException(ElementNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex);
    }
}
