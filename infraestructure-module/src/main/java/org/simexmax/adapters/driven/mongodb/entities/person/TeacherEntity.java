package org.simexmax.adapters.driven.mongodb.entities.person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.simexmax.adapters.driven.mongodb.entities.course.SubjectEntity;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Represents a teacher.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Document("teachers")
@Getter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class TeacherEntity extends APersonEntity {
    /**
     * Student code
     */
    @Indexed(unique = true)
    private String code;
    /**
     * List of subjects taught by the teacher.
     */
    private List<SubjectEntity> subjectsTaught;
}
