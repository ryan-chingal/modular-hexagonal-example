package org.simexmax.ports.in;

import org.simexmax.model.person.Student;

import java.util.List;
import java.util.Optional;

/**
 * This interface defines basic operations related to student management.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public interface IStudentBasicOperationsUseCase {
    /**
     * Retrieves a list of all students.
     *
     * @return A list containing all students.
     */
    List<Student> getAllStudents();

    /**
     * Retrieves a student by their code or identification.
     *
     * @param ID The code or identification of the student.
     * @return An {@link Optional} containing the student if found, or empty if not.
     */
    Optional<Student> getStudentByCodeOrIdentification(String ID);

    /**
     * Creates a new student.
     *
     * @param student The student to be created.
     * @return An {@link Optional} containing the created student if successful, or empty if not.
     */
    Optional<Student> createStudent(Student student);
}
