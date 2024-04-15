package org.simexmax.ports.out;

import org.simexmax.model.course.Subject;

import java.util.List;
import java.util.Optional;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@neotropic.co>
 */
public interface ISubjectPersistencePort {
    /**
     * Get all subjects
     *
     * @return A list of subjects
     */
    List<Subject> getAllSubjects();

    /**
     * Get a subject looking by subject code
     *
     * @param subjectCode subject code
     * @return subject found
     */
    Optional<Subject> getSubjectByCode(String subjectCode);

    /**
     * Create a subject
     *
     * @param subject subject to be created
     * @return subject created
     */
    Optional<Subject> createSubject(Subject subject);

    /**
     * Update the information of a subject
     *
     * @param subject subject to be updated
     * @return subject updated
     */
    Optional<Subject> updateSubject(Subject subject);
}
