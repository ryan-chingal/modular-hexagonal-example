package org.simexmax.adapters.driven.mongodb.repositories;

import org.simexmax.adapters.driven.mongodb.entities.course.GradeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Repository
public interface GradeRepository extends MongoRepository<GradeEntity, String> {
    @Query("{$or:[{'student.code': ?0}, {'subject.code': ?1}, {'period': ?2}] }")
    Optional<GradeEntity> findByStudentSubjectPeriod(String studentCode, String subjectCode, Integer period);
    @Query("{$or:[{'student.code': ?0}, {'subject.code': ?1}] }")
    List<GradeEntity> findAllStudentGradesBySubject(String studentCode, String subjectCode);

}

