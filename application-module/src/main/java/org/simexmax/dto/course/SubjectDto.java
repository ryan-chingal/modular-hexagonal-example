package org.simexmax.dto.course;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.simexmax.dto.person.TeacherDto;

import java.util.List;

/**
 * Represents a subject.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Getter
@Builder
public class SubjectDto {
    /**
     * Subject code
     */
    private String code;
    /**
     * Name of the subject.
     */
    private String subjectName;
    /**
     * Teacher who teaches the subject.
     */
    private TeacherDto teacher;
    /**
     * List of exams associated with the subject.
     */
    @Singular("exam")
    private List<GradeDto> examList;
}
