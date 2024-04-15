package org.simexmax.dto;

import lombok.Builder;
import lombok.Getter;
import org.simexmax.dto.course.SubjectDto;
import org.simexmax.dto.person.StudentDto;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Getter
@Builder
public class SubjectFinalGradeDto {
    /**
     * The subject for which the final grade is recorded.
     */
    private final SubjectDto subject;
    /**
     * The student whose final grade is recorded.
     */
    private final StudentDto student;
    /**
     * The final grade achieved by the student in the subject.
     */
    private final Double finalGrade;
}
