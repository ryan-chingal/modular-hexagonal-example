package org.simexmax.ports.in;

import org.simexmax.model.course.Grade;
import org.simexmax.model.course.SubjectGrades;

import java.util.List;

/**
 * Interface for retrieving grades for students.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@neotropic.co>
 */
public interface IStudentGetAllGradesBySubjectUseCase {
    /**
     * Retrieves all grades for a student in a specific subject.
     *
     * @param studentId The ID of the student.
     * @param subjectId The ID of the subject.
     * @return A list of {@link Grade} objects representing the grades of the student in the specified subject.
     */
    List<Grade> getAllStudentGradesBySubject(String studentId, String subjectId);

    /**
     * Retrieves all grades for a student.
     *
     * @param studentId The ID of the student.
     * @return A list of {@link SubjectGrades} objects representing the grades of the student in all subjects.
     */
    List<SubjectGrades> getAllStudentGrades(String studentId);
}
