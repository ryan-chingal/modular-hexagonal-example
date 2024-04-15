package org.simexmax.handlers.commands;

import org.simexmax.ports.in.ITeacherGradeManagerCommandUseCase;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class TeacherHandlerCommand {
    private final ITeacherGradeManagerCommandUseCase teacherGradeManagerUseCase;

    public TeacherHandlerCommand(ITeacherGradeManagerCommandUseCase teacherGradeManagerUseCase) {
        this.teacherGradeManagerUseCase = teacherGradeManagerUseCase;
    }

    /**
     * Registers a student's grade in a subject for a specific grading period.
     *
     * @param studentId The ID of the student.
     * @param subjectId The ID of the subject.
     * @param period    The grading period.
     * @param grade     The grade to be registered.
     */
    public void registerStudentGradeInSubjectByPeriod(String studentId, String subjectId, Integer period, Double grade) {
        teacherGradeManagerUseCase.registerStudentGradeInSubjectByPeriod(studentId, subjectId, period, grade);
    }

    /**
     * Changes a student's grade in a subject for a specific grading period.
     *
     * @param studentId The ID of the student.
     * @param subjectId The ID of the subject.
     * @param period    The grading period.
     * @param grade     The new grade to be assigned.
     */
    public void changeStudentGradeInSubjectByPeriod(String studentId, String subjectId, Integer period, Double grade) {
        teacherGradeManagerUseCase.changeStudentGradeInSubjectByPeriod(studentId, subjectId, period, grade);
    }

}
