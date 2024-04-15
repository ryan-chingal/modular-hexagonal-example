package org.simexmax.adapters.driven.mongodb.entities.person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.simexmax.adapters.driven.mongodb.entities.course.SubjectEntity;
import org.simexmax.dto.course.SubjectDto;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Represents a student.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Document("students")
@Getter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class StudentEntity extends APersonEntity {
    /**
     * Student code
     */
    @Indexed(unique = true)
    private String code;
    /**
     * List of subjects in which the student is enrolled.
     */
    private List<SubjectEntity> enrolledSubjects;

}

