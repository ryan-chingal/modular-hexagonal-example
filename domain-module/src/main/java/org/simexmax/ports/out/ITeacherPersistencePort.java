package org.simexmax.ports.out;

import org.simexmax.model.person.Teacher;

import java.util.List;
import java.util.Optional;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@neotropic.co>
 */
public interface ITeacherPersistencePort {
    /**
     * Retrieves a list of all teachers.
     *
     * @return A list of all teachers.
     */
    List<Teacher> getAllTeachers();

    /**
     * Retrieves a teacher by their ID.
     *
     * @param teacherId The ID of the teacher to retrieve.
     * @return The teacher with the specified ID.
     */
    Optional<Teacher> getTeacherByCode(String teacherId);

    /**
     * Creates a new teacher.
     *
     * @param teacher The teacher object to be created.
     */
    Optional<Teacher> createTeacher(Teacher teacher);
}
