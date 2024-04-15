package org.simexmax.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.simexmax.dto.course.GradeDto;
import org.simexmax.dto.course.SubjectDto;

import java.util.List;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Getter
@Builder
public class SubjectGradesDto {
    /**
     * The subject for which the final grade is recorded.
     */
    private final SubjectDto subject;
    /**
     * Grades related to a subject.
     */
    @Singular
    private final List<GradeDto> subjectGrades;
}
