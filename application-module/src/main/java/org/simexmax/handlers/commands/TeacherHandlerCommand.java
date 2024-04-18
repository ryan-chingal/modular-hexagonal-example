package org.simexmax.handlers.commands;

import org.simexmax.dto.person.TeacherDto;
import org.simexmax.mappers.TeacherDtoMapper;
import org.simexmax.ports.in.ITeacherBasicOperationsUseCase;
import org.simexmax.ports.in.ITeacherGradeManagerCommandUseCase;

import java.util.Optional;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class TeacherHandlerCommand {
    private final ITeacherGradeManagerCommandUseCase teacherGradeManagerUseCase;
    private final ITeacherBasicOperationsUseCase teacherBasicOperationsUseCase;
    private final TeacherDtoMapper teacherDtoMapper;

    public TeacherHandlerCommand(ITeacherGradeManagerCommandUseCase teacherGradeManagerUseCase,
                                 ITeacherBasicOperationsUseCase teacherBasicOperationsUseCase, TeacherDtoMapper teacherDtoMapper) {
        this.teacherGradeManagerUseCase = teacherGradeManagerUseCase;
        this.teacherBasicOperationsUseCase = teacherBasicOperationsUseCase;
        this.teacherDtoMapper = teacherDtoMapper;
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


    /**
     * Creates a new teacher.
     *
     * @param teacher The teacher to be created.
     * @return An {@link Optional} containing the created student if successful, or empty if not.
     */
    public Optional<TeacherDto> createTeacher(TeacherDto teacher){
        return teacherBasicOperationsUseCase.createTeacher(teacherDtoMapper.toModel(teacher)).map(teacherDtoMapper::toDto);
    }
}
