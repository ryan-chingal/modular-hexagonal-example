package org.simexmax.handlers.queries;

import org.simexmax.dto.SubjectFinalGradeDto;
import org.simexmax.dto.SubjectGradesDto;
import org.simexmax.dto.course.GradeDto;
import org.simexmax.dto.person.StudentDto;
import org.simexmax.mappers.GradeDtoMapper;
import org.simexmax.mappers.StudentDtoMapper;
import org.simexmax.mappers.SubjectFinalGradeDtoMapper;
import org.simexmax.mappers.SubjectGradesDtoMapper;
import org.simexmax.model.course.Grade;
import org.simexmax.model.course.SubjectFinalGrade;
import org.simexmax.model.course.SubjectGrades;
import org.simexmax.model.person.Student;
import org.simexmax.ports.in.IStudentBasicOperationsUseCase;
import org.simexmax.ports.in.IStudentGetAllGradesBySubjectUseCase;
import org.simexmax.ports.in.IStudentGetSubjectFinalGradeUseCase;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class StudentHandlerQuery {
    private final IStudentGetAllGradesBySubjectUseCase studentGetAllGradesBySubjectUseCase;
    private final IStudentGetSubjectFinalGradeUseCase studentGetSubjectFinalGradeUseCase;
    private final IStudentBasicOperationsUseCase studentBasicOperationsUseCase;
    private final GradeDtoMapper gradeDtoMapper;
    private final StudentDtoMapper studentDtoMapper;
    private final SubjectGradesDtoMapper subjectGradesDtoMapper;
    private final SubjectFinalGradeDtoMapper subjectFinalGradeDtoMapper;

    public StudentHandlerQuery(IStudentGetAllGradesBySubjectUseCase studentGetAllGradesBySubjectUseCase,
                               IStudentGetSubjectFinalGradeUseCase studentGetSubjectFinalGradeUseCase, IStudentBasicOperationsUseCase studentBasicOperationsUseCase, GradeDtoMapper gradeDtoMapper, StudentDtoMapper studentDtoMapper,
                               SubjectGradesDtoMapper subjectGradesDtoMapper, SubjectFinalGradeDtoMapper subjectFinalGradeDtoMapper) {
        this.studentGetAllGradesBySubjectUseCase = studentGetAllGradesBySubjectUseCase;
        this.studentGetSubjectFinalGradeUseCase = studentGetSubjectFinalGradeUseCase;
        this.studentBasicOperationsUseCase = studentBasicOperationsUseCase;
        this.gradeDtoMapper = gradeDtoMapper;
        this.studentDtoMapper = studentDtoMapper;
        this.subjectGradesDtoMapper = subjectGradesDtoMapper;
        this.subjectFinalGradeDtoMapper = subjectFinalGradeDtoMapper;
    }


    /**
     * Retrieves a list of all students.
     *
     * @return A list of {@link Student}.
     */
    public List<StudentDto> getAllStudents() {
        return studentBasicOperationsUseCase.getAllStudents().stream()
                .map(studentDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a student by their code or identification.
     *
     * @param ID The code or identification of the student.
     * @return An {@link Optional} containing the student if found, or empty if not.
     */
    public Optional<StudentDto> getStudentByCodeOrIdentification(String ID){
        return studentBasicOperationsUseCase.getStudentByCodeOrIdentification(ID)
                .map(studentDtoMapper::toDto);
    }

    /**
     * Retrieves all grades for a student in a specific subject.
     *
     * @param studentId The ID of the student.
     * @param subjectId The ID of the subject.
     * @return A list of {@link Grade} objects representing the grades of the student in the specified subject.
     */
    public List<GradeDto> getAllStudentGradesBySubject(String studentId, String subjectId) {
        return studentGetAllGradesBySubjectUseCase.getAllStudentGradesBySubject(studentId, subjectId).stream()
                .map(gradeDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all grades for a student.
     *
     * @param studentId The ID of the student.
     * @return A list of {@link SubjectGrades} objects representing the grades of the student in all subjects.
     */
    public List<SubjectGradesDto> getAllStudentGrades(String studentId) {
        return studentGetAllGradesBySubjectUseCase.getAllStudentGrades(studentId).stream()
                .map(subjectGradesDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves the final grades of a student for all subjects.
     *
     * @param studentId The ID of the student.
     * @return A list of {@link SubjectFinalGrade} objects representing the final grades of the student in all subjects.
     */
    public List<SubjectFinalGradeDto> getAllStudentFinalGrade(String studentId) {
        return studentGetSubjectFinalGradeUseCase.getAllStudentFinalGrade(studentId).stream()
                .map(subjectFinalGradeDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves the final grade of a student for a specific subject.
     *
     * @param studentId The ID of the student.
     * @param subjectId The ID of the subject.
     * @return The final grade of the student in the specified subject.
     */
    public Optional<SubjectFinalGradeDto> getAllStudentFinalGradeBySubject(String studentId, String subjectId) {
        return studentGetSubjectFinalGradeUseCase.getAllStudentFinalGradeBySubject(studentId, subjectId)
                .flatMap(subjectFinalGradeDtoMapper::toOptionalDto);
    }
}
