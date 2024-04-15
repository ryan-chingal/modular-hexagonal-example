package org.simexmax.usecases.student;

import org.simexmax.exceptions.ElementNotFoundException;
import org.simexmax.model.commons.MathematicalToolsSubject;
import org.simexmax.model.course.Grade;
import org.simexmax.model.course.SubjectFinalGrade;
import org.simexmax.model.person.Student;
import org.simexmax.ports.in.IStudentGetSubjectFinalGradeUseCase;
import org.simexmax.ports.out.IGradePersistencePort;
import org.simexmax.ports.out.IStudentPersistencePort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class StudentGetSubjectFinalGradeImpl implements IStudentGetSubjectFinalGradeUseCase {
    private final IStudentPersistencePort studentPersistence;
    private final IGradePersistencePort gradePersistence;

    public StudentGetSubjectFinalGradeImpl(IStudentPersistencePort studentPersistence, IGradePersistencePort gradePersistence) {
        this.studentPersistence = studentPersistence;
        this.gradePersistence = gradePersistence;
    }

    /**
     * Retrieves the final grades of a student for all subjects.
     *
     * @param studentId The ID of the student.
     * @return A list of {@link SubjectFinalGrade} objects representing the final grades of the student in all subjects.
     */
    @Override
    public List<SubjectFinalGrade> getAllStudentFinalGrade(String studentId) {
        return studentPersistence.getStudentByCodeOrId(studentId)
                .map(student -> student.getEnrolledSubjects().stream()
                        .map(subject -> SubjectFinalGrade.builder()
                                .subject(subject)
                                .student(student)
                                .finalGrade(MathematicalToolsSubject.calculateFinalNote(
                                        gradePersistence.getAllStudentGradesBySubject(student.getCode(), subject.getCode())))
                                .build())
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new ElementNotFoundException(11, String.format("Student with code or identification %s not found.", studentId)));
    }

    /**
     * Retrieves the final grade of a student for a specific subject.
     *
     * @param studentId The ID of the student.
     * @param subjectId The ID of the subject.
     * @return The final grade of the student in the specified subject.
     */
    @Override
    public Optional<SubjectFinalGrade> getAllStudentFinalGradeBySubject(String studentId, String subjectId) {
        return studentPersistence.getStudentByCodeOrId(studentId)
                .flatMap(student -> {
                    List<Grade> allStudentGradesBySubject = gradePersistence.getAllStudentGradesBySubject(student.getCode(), subjectId);
                    if (!allStudentGradesBySubject.isEmpty()) {
                        return Optional.of(SubjectFinalGrade.builder()
                                .student(student)
                                .subject(allStudentGradesBySubject.stream().findFirst().map(Grade::getSubject).orElse(null))
                                .finalGrade(MathematicalToolsSubject.calculateFinalNote(allStudentGradesBySubject))
                                .build());
                    } else
                        return Optional.empty();
                });
    }
}
