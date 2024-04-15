package org.simexmax.handlers.queries;

import org.simexmax.dto.SubjectFinalGradeDto;
import org.simexmax.mappers.SubjectFinalGradeDtoMapper;
import org.simexmax.model.course.SubjectFinalGrade;
import org.simexmax.ports.in.ITeacherGradeManagerQueryUseCase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class TeacherHandlerQuery {
    private final ITeacherGradeManagerQueryUseCase teacherGradeManagerUseCase;
    private final SubjectFinalGradeDtoMapper subjectFinalGradeDtoMapper;

    public TeacherHandlerQuery(ITeacherGradeManagerQueryUseCase teacherGradeManagerQueryUseCase, SubjectFinalGradeDtoMapper subjectFinalGradeDtoMapper) {
        this.teacherGradeManagerUseCase = teacherGradeManagerQueryUseCase;
        this.subjectFinalGradeDtoMapper = subjectFinalGradeDtoMapper;
    }

    /**
     * Retrieves the final grades of students for a specific subject.
     *
     * @param subjectId The ID of the subject.
     * @return A list of {@link SubjectFinalGrade} objects representing the final grades of students in the subject.
     */
    public List<SubjectFinalGradeDto> getStudentsFinalGradesBySubject(String subjectId) {
        return teacherGradeManagerUseCase.getStudentsFinalGradesBySubject(subjectId).stream()
                .map(subjectFinalGradeDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
