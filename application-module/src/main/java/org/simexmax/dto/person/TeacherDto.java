package org.simexmax.dto.person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.simexmax.dto.course.SubjectDto;

import java.util.List;

/**
 * Represents a teacher.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Getter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class TeacherDto extends APersonDto {
    /**
     * Student code
     */
    private String code;

}
