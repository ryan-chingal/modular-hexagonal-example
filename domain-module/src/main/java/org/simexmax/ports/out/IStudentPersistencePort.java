package org.simexmax.ports.out;

import org.simexmax.model.person.Student;

import java.util.List;
import java.util.Optional;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@neotropic.co>
 */
public interface IStudentPersistencePort {
    /**
     * Retrieves a list of all students.
     *
     * @return A list of all students.
     */
    List<Student> getAllStudent();

    /**
     * Retrieves a student by their ID or code.
     *
     * @param studentId The ID or code of the student to retrieve.
     * @return The student with the specified ID or code.
     */
    Optional<Student> getStudentByCodeOrId(String studentId);

    /**
     * Creates a new student.
     *
     * @param student The student object to be created.
     */
    Optional<Student> createStudent(Student student);
}
