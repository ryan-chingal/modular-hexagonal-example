package org.simexmax.usecases.teacher;

import org.simexmax.exceptions.ElementNotFoundException;
import org.simexmax.exceptions.InvalidArgumentException;
import org.simexmax.exceptions.InvalidOperationException;
import org.simexmax.model.commons.MathematicalToolsSubject;
import org.simexmax.model.course.Grade;
import org.simexmax.model.course.Subject;
import org.simexmax.model.course.SubjectFinalGrade;
import org.simexmax.model.person.Student;
import org.simexmax.ports.in.ITeacherGradeManagerCommandUseCase;
import org.simexmax.ports.in.ITeacherGradeManagerQueryUseCase;
import org.simexmax.ports.out.IGradePersistencePort;
import org.simexmax.ports.out.IStudentPersistencePort;
import org.simexmax.ports.out.ISubjectPersistencePort;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class TeacherGradeManagerUseCaseImpl implements ITeacherGradeManagerCommandUseCase, ITeacherGradeManagerQueryUseCase {
    private final IStudentPersistencePort studentPersistence;
    private final ISubjectPersistencePort subjectPersistence;
    private final IGradePersistencePort gradePersistence;

    public TeacherGradeManagerUseCaseImpl(IStudentPersistencePort studentPersistence,
                                          ISubjectPersistencePort subjectPersistence, IGradePersistencePort gradePersistence) {
        this.studentPersistence = studentPersistence;
        this.subjectPersistence = subjectPersistence;
        this.gradePersistence = gradePersistence;
    }

    /**
     * Registers a student's grade in a subject for a specific grading period.
     *
     * @param studentId The ID of the student.
     * @param subjectId The ID of the subject.
     * @param period    The grading period.
     * @param grade     The grade to be registered.
     */
    @Override
    public void registerStudentGradeInSubjectByPeriod(String studentId, String subjectId, Integer period, Double grade) {
        if (studentId == null || studentId.isEmpty())
            throw new InvalidArgumentException(1, "studentId is required");

        if (subjectId == null || subjectId.isEmpty())
            throw new InvalidArgumentException(2, "subjectId is required");

        if (period == null)
            throw new InvalidArgumentException(3, "period is required");

        if (period < 1 || period > 3)
            throw new InvalidOperationException(5, String.format("The period entered %s is invalid, 1 - 3 is allowed",
                    period));

        if (grade == null)
            throw new InvalidArgumentException(4, "grade is required");

        if (grade < 0 || grade > 5)
            throw new InvalidOperationException(5, String.format("The grade entered %s is invalid, 0 - 5 is allowed",
                    grade));

        Optional<Subject> subjectFound = subjectPersistence.getSubjectByCode(subjectId);
        if (subjectFound.isEmpty())
            throw new ElementNotFoundException(6, String.format("Subject %s not found", subjectId));

        if (subjectFound.get().getExamList() != null && subjectFound.get().getExamList().size() >= 3)
            throw new InvalidOperationException(7, String.format("The subject %s has already completed all its grades.",
                    subjectId));

        Optional<Student> studentFound = studentPersistence.getStudentByCodeOrId(studentId);
        if (studentFound.isEmpty())
            throw new ElementNotFoundException(8, String.format("Student %s not found", studentId));

        Optional<Grade> newSubjectGrade = gradePersistence.createGrade(new Grade.Builder()
                .subject(subjectFound.get())
                .student(studentFound.get())
                .period(period)
                .grade(grade)
                .build());
        if (newSubjectGrade.isEmpty())
            throw new InvalidOperationException(9, "The grade could not be created.");

        if (subjectFound.get().getExamList() != null)
            subjectFound.get().getExamList().add(newSubjectGrade.get());
        else
            subjectFound.get().setExamList(List.of(newSubjectGrade.get()));

        Optional<Subject> updatedSubject = subjectPersistence.updateSubject(subjectFound.get());
        if (updatedSubject.isEmpty()) {
            gradePersistence.deleteGrade(newSubjectGrade.get());
            throw new InvalidOperationException(9, "The grade could not be created.");
        }
    }

    /**
     * Changes a student's grade in a subject for a specific grading period.
     *
     * @param studentId The ID of the student.
     * @param subjectId The ID of the subject.
     * @param period    The grading period.
     * @param grade     The new grade to be assigned.
     */
    @Override
    public void changeStudentGradeInSubjectByPeriod(String studentId, String subjectId, Integer period, Double grade) {
        if (studentId == null || studentId.isEmpty())
            throw new InvalidArgumentException(1, "studentId is required");

        if (subjectId == null || subjectId.isEmpty())
            throw new InvalidArgumentException(2, "subjectId is required");

        if (period == null)
            throw new InvalidArgumentException(3, "period is required");

        if (period < 1 || period > 3)
            throw new InvalidOperationException(5, String.format("The period entered %s is invalid, 1 - 3 is allowed",
                    period));

        if (grade == null)
            throw new InvalidArgumentException(4, "grade is required");

        if (grade < 0 || grade > 5)
            throw new InvalidOperationException(5, String.format("The grade entered %s is invalid, 0 - 5 is allowed",
                    grade));

        Optional<Subject> subjectFound = subjectPersistence.getSubjectByCode(subjectId);
        if (subjectFound.isEmpty())
            throw new ElementNotFoundException(6, String.format("Subject %s not found", subjectId));

        if (subjectFound.get().getExamList() != null || subjectFound.get().getExamList().isEmpty())
            throw new InvalidOperationException(10, String.format("There are no notes associated with the subject %s.",
                    subjectId));

        Optional<Student> studentFound = studentPersistence.getStudentByCodeOrId(studentId);
        if (studentFound.isEmpty())
            throw new ElementNotFoundException(8, String.format("Student %s not found", studentId));

        Optional<Grade> toUpdateGrade = subjectFound.get().getExamList().stream().filter(subjectGrade ->
                        Objects.equals(subjectGrade.getPeriod(), period) && subjectGrade.getStudent().getCode().equals(studentFound.get().getCode()))
                .findFirst();

        if (toUpdateGrade.isEmpty())
            throw new ElementNotFoundException(11, String.format("No grade was found to update, for student %s in period %s.",
                    studentId, period));

        toUpdateGrade.get().setGrade(grade);
        Optional<Grade> gradeUpdated = gradePersistence.updateGrade(toUpdateGrade.get());
        if (gradeUpdated.isEmpty())
            throw new ElementNotFoundException(12, String.format("Failed to update course grade %s for student %s.",
                    studentId, studentId));
    }

    /**
     * Retrieves the final grades of students for a specific subject.
     *
     * @param subjectId The ID of the subject.
     * @return A list of {@link SubjectFinalGrade} objects representing the final grades of students in the subject.
     */
    public List<SubjectFinalGrade> getStudentsFinalGradesBySubject(String subjectId) {
        if (subjectId == null || subjectId.isEmpty())
            throw new InvalidArgumentException(2, "subjectId is required");

        Optional<Subject> subjectFound = subjectPersistence.getSubjectByCode(subjectId);
        if (subjectFound.isEmpty())
            throw new ElementNotFoundException(6, String.format("Subject %s not found", subjectId));

        if (subjectFound.get().getExamList() != null || subjectFound.get().getExamList().isEmpty())
            throw new InvalidOperationException(10, String.format("There are no notes associated with the subject %s.",
                    subjectId));

        // Group notes by student
        Map<Student, List<Grade>> gradesByStudent = subjectFound.get().getExamList().stream()
                .collect(Collectors.groupingBy(Grade::getStudent));

        // Iterate over each student and pass their notes to the calculateFinalNote method
        return gradesByStudent.entrySet().stream()
                .map(entry -> {
                    Student student = entry.getKey();
                    List<Grade> grades = entry.getValue();
                    double finalGrade = MathematicalToolsSubject.calculateFinalNote(grades);

                    return new SubjectFinalGrade.Builder()
                            .finalGrade(finalGrade)
                            .student(student)
                            .subject(subjectFound.get())
                            .build();
                })
                .collect(Collectors.toList());
    }
}
