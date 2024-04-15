package org.simexmax.adapters.driven.mongodb.services;

import org.simexmax.adapters.driven.mongodb.entities.course.SubjectEntity;
import org.simexmax.adapters.driven.mongodb.mappers.SubjectEntityMapper;
import org.simexmax.adapters.driven.mongodb.repositories.SubjectRepository;
import org.simexmax.model.course.Subject;
import org.simexmax.ports.out.ISubjectPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class represents a service for managing subjects.
 * It implements the ISubjectPersistencePort interface.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Service
public class SubjectSpringJpaAdapter implements ISubjectPersistencePort {
    private final SubjectRepository subjectRepository;
    private final SubjectEntityMapper subjectEntityMapper;

    public SubjectSpringJpaAdapter(SubjectRepository subjectRepository, SubjectEntityMapper subjectEntityMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectEntityMapper = subjectEntityMapper;
    }


    /**
     * Get all subjects
     *
     * @return A list of subjects
     */
    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll().stream().map(subjectEntityMapper::toModel).collect(Collectors.toList());
    }

    /**
     * Get a subject looking by subject code
     *
     * @param subjectCode subject code
     * @return subject found
     */
    @Override
    public Optional<Subject> getSubjectByCode(String subjectCode) {
        return subjectRepository.findByCode(subjectCode).map(subjectEntityMapper::toModel);
    }

    /**
     * Create a subject
     *
     * @param subject subject to be created
     * @return subject created
     */
    @Override
    public Optional<Subject> createSubject(Subject subject) {
        return subjectEntityMapper.toOptionalModel(subjectRepository.insert(subjectEntityMapper.toEntity(subject)));
    }

    /**
     * Update the information of a subject
     *
     * @param subject subject to be updated
     * @return subject updated
     */
    @Override
    public Optional<Subject> updateSubject(Subject subject) {
        return subjectRepository.findByCode(subject.getCode()).map(subjectFound -> {
            SubjectEntity entity = subjectEntityMapper.toEntity(subject);
            entity.setID(subjectFound.getID());
            return subjectEntityMapper.toOptionalModel(subjectRepository.save(entity));
        }).orElse(Optional.empty());
    }
}

