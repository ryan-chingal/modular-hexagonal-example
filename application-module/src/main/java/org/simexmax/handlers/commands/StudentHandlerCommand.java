package org.simexmax.handlers.commands;

import org.simexmax.dto.person.StudentDto;
import org.simexmax.mappers.StudentDtoMapper;
import org.simexmax.ports.in.IStudentBasicOperationsUseCase;

import java.util.Optional;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class StudentHandlerCommand {
    private final IStudentBasicOperationsUseCase studentBasicOperationsUseCase;
    private final StudentDtoMapper studentDtoMapper;

    public StudentHandlerCommand(IStudentBasicOperationsUseCase studentBasicOperationsUseCase, StudentDtoMapper studentDtoMapper) {
        this.studentBasicOperationsUseCase = studentBasicOperationsUseCase;
        this.studentDtoMapper = studentDtoMapper;
    }

    /**
     * Creates a new student.
     *
     * @param student The student to be created.
     * @return An {@link Optional} containing the created student if successful, or empty if not.
     */
    public Optional<StudentDto> createStudent(StudentDto student) {
        return studentBasicOperationsUseCase.createStudent(studentDtoMapper.toModel(student)).map(studentDtoMapper::toDto);
    }
}
