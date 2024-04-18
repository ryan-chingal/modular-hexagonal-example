package org.simexmax.handlers.queries;

import org.simexmax.dto.SubjectFinalGradeDto;
import org.simexmax.dto.person.TeacherDto;
import org.simexmax.mappers.SubjectFinalGradeDtoMapper;
import org.simexmax.mappers.TeacherDtoMapper;
import org.simexmax.model.course.SubjectFinalGrade;
import org.simexmax.ports.in.ITeacherBasicOperationsUseCase;
import org.simexmax.ports.in.ITeacherGradeManagerQueryUseCase;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class TeacherHandlerQuery {
    private final ITeacherGradeManagerQueryUseCase teacherGradeManagerUseCase;
    private final ITeacherBasicOperationsUseCase teacherBasicOperationsUseCase;
    private final SubjectFinalGradeDtoMapper subjectFinalGradeDtoMapper;
    private final TeacherDtoMapper teacherDtoMapper;

    public TeacherHandlerQuery(ITeacherGradeManagerQueryUseCase teacherGradeManagerQueryUseCase,
                               ITeacherBasicOperationsUseCase teacherBasicOperationsUseCase,
                               SubjectFinalGradeDtoMapper subjectFinalGradeDtoMapper, TeacherDtoMapper teacherDtoMapper) {
        this.teacherGradeManagerUseCase = teacherGradeManagerQueryUseCase;
        this.teacherBasicOperationsUseCase = teacherBasicOperationsUseCase;
        this.subjectFinalGradeDtoMapper = subjectFinalGradeDtoMapper;
        this.teacherDtoMapper = teacherDtoMapper;
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

    /**
     * Retrieves a list of all teachers.
     *
     * @return A list containing all students.
     */
    public List<TeacherDto> getAllTeachers(){
        return teacherBasicOperationsUseCase.getAllTeachers().stream().map(teacherDtoMapper::toDto).toList();
    }

    /**
     * Retrieves a teacher by their code or identification.
     *
     * @param ID The code or identification of the teacher.
     * @return An {@link Optional} containing the student if found, or empty if not.
     */
    public Optional<TeacherDto> getTeacherByCodeOrIdentification(String ID){
        return teacherBasicOperationsUseCase.getTeacherByCodeOrIdentification(ID).map(teacherDtoMapper::toDto);
    }
}