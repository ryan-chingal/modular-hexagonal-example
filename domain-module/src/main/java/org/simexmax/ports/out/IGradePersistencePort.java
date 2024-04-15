package org.simexmax.ports.out;

import org.simexmax.model.course.Grade;

import java.util.List;
import java.util.Optional;

/**
 * This interface defines operations for managing grades.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@neotropic.co>
 */
public interface IGradePersistencePort {

    /**
     * Retrieves a list of all grades.
     *
     * @return A list containing all grades.
     */
    List<Grade> getAllGrades();

    /**
     * Retrieves a grade by its student and subject and period.
     *
     * @param studentId   The code or identification of the student.
     * @param subjectCode The code of the subject.
     * @param Period      The code of the grade.
     * @return An {@link Optional} containing the grade if found, or empty if not found.
     */
    Optional<Grade> getGradeByStudentSubjectPeriod(String studentId, String subjectCode, Integer Period);

    /**
     * Retrieves all grade by its student and subject.
     *
     * @param studentId   The code or identification of the student.
     * @param subjectCode The code of the subject.
     * @return An {@link Optional} containing the grade if found, or empty if not found.
     */
    List<Grade> getAllStudentGradesBySubject(String studentId, String subjectCode);

    /**
     * Create a new grade.
     *
     * @param Grade The grade to be updated.
     */
    Optional<Grade> createGrade(Grade Grade);

    /**
     * Update an existing grade.
     *
     * @param Grade The grade to be updated.
     */
    Optional<Grade> updateGrade(Grade Grade);

    /**
     * Delete an existing grade.
     *
     * @param Grade The grade to be updated.
     */
    void deleteGrade(Grade Grade);
}
