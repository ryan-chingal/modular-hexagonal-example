package org.simexmax.ports.in;

import org.simexmax.model.person.Teacher;

import java.util.List;
import java.util.Optional;

/**
 * This interface defines basic operations related to teacher management.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public interface ITeacherBasicOperationsUseCase {
    /**
     * Retrieves a list of all teachers.
     *
     * @return A list containing all students.
     */
    List<Teacher> getAllTeachers();

    /**
     * Retrieves a teacher by their code or identification.
     *
     * @param ID The code or identification of the teacher.
     * @return An {@link Optional} containing the student if found, or empty if not.
     */
    Optional<Teacher> getTeacherByCodeOrIdentification(String ID);

    /**
     * Creates a new teacher.
     *
     * @param teacher The teacher to be created.
     * @return An {@link Optional} containing the created student if successful, or empty if not.
     */
    Optional<Teacher> createTeacher(Teacher teacher);
}
