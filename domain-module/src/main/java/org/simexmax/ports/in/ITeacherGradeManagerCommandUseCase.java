package org.simexmax.ports.in;

import org.simexmax.model.course.SubjectFinalGrade;

import java.util.List;

/**
 * Interface for managing grades for teachers.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@neotropic.co>
 */
public interface ITeacherGradeManagerCommandUseCase {
    /**
     * Registers a student's grade in a subject for a specific grading period.
     *
     * @param studentId The ID of the student.
     * @param subjectId The ID of the subject.
     * @param period    The grading period.
     * @param grade     The grade to be registered.
     */
    void registerStudentGradeInSubjectByPeriod(String studentId, String subjectId, Integer period, Double grade);

    /**
     * Changes a student's grade in a subject for a specific grading period.
     *
     * @param studentId The ID of the student.
     * @param subjectId The ID of the subject.
     * @param period    The grading period.
     * @param grade     The new grade to be assigned.
     */
    void changeStudentGradeInSubjectByPeriod(String studentId, String subjectId, Integer period, Double grade);

}
