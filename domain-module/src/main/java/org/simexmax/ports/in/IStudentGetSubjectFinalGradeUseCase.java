package org.simexmax.ports.in;

import org.simexmax.model.course.SubjectFinalGrade;

import java.util.List;
import java.util.Optional;

/**
 * Interface for retrieving final grades for students.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@neotropic.co>
 */
public interface IStudentGetSubjectFinalGradeUseCase {
    /**
     * Retrieves the final grades of a student for all subjects.
     *
     * @param studentId The ID of the student.
     * @return A list of {@link SubjectFinalGrade} objects representing the final grades of the student in all subjects.
     */
    List<SubjectFinalGrade> getAllStudentFinalGrade(String studentId);

    /**
     * Retrieves the final grade of a student for a specific subject.
     *
     * @param studentId The ID of the student.
     * @param subjectId The ID of the subject.
     * @return The final grade of the student in the specified subject.
     */
    Optional<SubjectFinalGrade> getAllStudentFinalGradeBySubject(String studentId, String subjectId);
}
