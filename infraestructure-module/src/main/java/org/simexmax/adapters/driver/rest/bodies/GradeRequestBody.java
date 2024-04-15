package org.simexmax.adapters.driver.rest.bodies;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Getter
@Builder
public class GradeRequestBody {
    private Double grade;
}
