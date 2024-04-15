package org.simexmax.usecases.student;

import org.simexmax.exceptions.ElementNotFoundException;
import org.simexmax.model.course.Grade;
import org.simexmax.model.course.SubjectGrades;
import org.simexmax.ports.in.IStudentGetAllGradesBySubjectUseCase;
import org.simexmax.ports.out.IGradePersistencePort;
import org.simexmax.ports.out.IStudentPersistencePort;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class StudentGetAllGradesBySubjectUseCaseImpl implements IStudentGetAllGradesBySubjectUseCase {
    private final IStudentPersistencePort studentPersistence;
    private final IGradePersistencePort gradePersistence;

    public StudentGetAllGradesBySubjectUseCaseImpl(IStudentPersistencePort studentPersistence, IGradePersistencePort gradePersistence) {
        this.studentPersistence = studentPersistence;
        this.gradePersistence = gradePersistence;
    }

    /**
     * Retrieves all grades for a student in a specific subject.
     *
     * @param studentId The ID of the student.
     * @param subjectCode The ID of the subject.
     * @return A list of {@link Grade} objects representing the grades of the student in the specified subject.
     */
    @Override
    public List<Grade> getAllStudentGradesBySubject(String studentId, String subjectCode) {
        return gradePersistence.getAllStudentGradesBySubject(studentId, subjectCode);
    }

    /**
     * Retrieves all grades for a student.
     *
     * @param studentId The ID of the student.
     * @return A list of {@link SubjectGrades} objects representing the grades of the student in all subjects.
     */
    @Override
    public List<SubjectGrades> getAllStudentGrades(String studentId) {
        return studentPersistence.getStudentByCodeOrId(studentId)
                .map(student -> student.getEnrolledSubjects().stream()
                        .map(subject -> SubjectGrades.builder()
                                .subject(subject)
                                .subjectGrades(gradePersistence.getAllStudentGradesBySubject(student.getCode(), subject.getCode()))
                                .build())
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new ElementNotFoundException(11, String.format("Student with code or identification %s not found.", studentId)));
    }
}
