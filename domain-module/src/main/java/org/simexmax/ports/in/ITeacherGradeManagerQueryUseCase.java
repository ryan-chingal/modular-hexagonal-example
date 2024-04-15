package org.simexmax.ports.in;

import org.simexmax.model.course.SubjectFinalGrade;

import java.util.List;

/**
 * Interface for managing grades for teachers.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@neotropic.co>
 */
public interface ITeacherGradeManagerQueryUseCase {

    /**
     * Retrieves the final grades of students for a specific subject.
     *
     * @param subjectId The ID of the subject.
     * @return A list of {@link SubjectFinalGrade} objects representing the final grades of students in the subject.
     */
    List<SubjectFinalGrade> getStudentsFinalGradesBySubject(String subjectId);
}
