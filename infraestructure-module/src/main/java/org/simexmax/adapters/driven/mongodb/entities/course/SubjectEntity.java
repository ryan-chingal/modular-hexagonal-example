package org.simexmax.adapters.driven.mongodb.entities.course;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.simexmax.adapters.driven.mongodb.entities.person.TeacherEntity;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

/**
 * Represents a subject.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Document("subjects")
@Getter
@Builder
public class SubjectEntity {
    /**
     * Exam ID
     */
    @MongoId
    @Setter
    private String ID;
    /**
     * Subject code
     */
    @Indexed(unique = true)
    private String code;
    /**
     * Name of the subject.
     */
    private String subjectName;
    /**
     * Teacher who teaches the subject.
     */
    private TeacherEntity teacher;
    /**
     * List of exams associated with the subject.
     */
    @Singular("exam")
    private List<GradeEntity> examList;
}

