package org.simexmax.adapters.driven.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Repository
public interface GenericPersonRepository<T> extends MongoRepository<T, String> {
    @Query("{$or:[{'code': ?0}, {'identificationList.identification': ?1}] }")
    Optional<T> findByCodeOrIdentification(String code, String identification);
}
