package org.simexmax.dto.course;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.simexmax.dto.person.StudentDto;

/**
 * Represents an exam.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Getter
@Builder
public class GradeDto {

    /**
     * The grade obtained in the exam.
     */
    @Setter
    private Double grade;
    /**
     * The student who took the exam.
     */
    private StudentDto student;
    /**
     * The subject of the exam.
     */
    private SubjectDto subject;

    /**
     * Weight of the exam in the final grade calculation.
     */
    private Double weighting;

    /**
     * Period in which the exam was conducted.
     */
    private Integer period;
}
