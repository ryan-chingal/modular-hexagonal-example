package org.simexmax.adapters.driven.mongodb.repositories;

import org.simexmax.adapters.driven.mongodb.entities.course.SubjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Repository
public interface SubjectRepository extends MongoRepository<SubjectEntity, String> {
    Optional<SubjectEntity> findByCode(String code);
}