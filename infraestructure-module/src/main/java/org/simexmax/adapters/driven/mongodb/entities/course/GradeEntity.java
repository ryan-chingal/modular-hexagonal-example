package org.simexmax.adapters.driven.mongodb.entities.course;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.simexmax.adapters.driven.mongodb.entities.person.StudentEntity;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * Represents an exam.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Document("grades")
@Getter
@Builder
public class GradeEntity {

    /**
     * Exam ID
     */
    @MongoId
    @Setter
    private String ID;
    /**
     * The grade obtained in the exam.
     */
    @Setter
    private Double grade;
    /**
     * The student who took the exam.
     */
    private StudentEntity student;
    /**
     * The subject of the exam.
     */
    private SubjectEntity subject;

    /**
     * Weight of the exam in the final grade calculation.
     */
    private Double weighting;

    /**
     * Period in which the exam was conducted.
     */
    private Integer period;
}


