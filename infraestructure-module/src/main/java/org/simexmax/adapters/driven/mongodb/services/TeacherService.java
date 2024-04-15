package org.simexmax.adapters.driven.mongodb.services;

import org.simexmax.adapters.driven.mongodb.entities.person.TeacherEntity;
import org.simexmax.adapters.driven.mongodb.mappers.TeacherEntityMapper;
import org.simexmax.adapters.driven.mongodb.repositories.GenericPersonRepository;
import org.simexmax.model.person.Teacher;
import org.simexmax.ports.out.ITeacherPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class represents a service for managing teachers.
 * It implements the ITeacherPersistencePort interface.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Service
public class TeacherService implements ITeacherPersistencePort {
    private final GenericPersonRepository<TeacherEntity> teacherRepository;
    private final TeacherEntityMapper teacherEntityMapper;

    public TeacherService(GenericPersonRepository<TeacherEntity> teacherRepository, TeacherEntityMapper teacherEntityMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherEntityMapper = teacherEntityMapper;
    }

    /**
     * Retrieves a list of all teachers.
     *
     * @return A list of all teachers.
     */
    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll().stream().map(teacherEntityMapper::toModel).toList();
    }

    /**
     * Retrieves a teacher by their ID.
     *
     * @param teacherId The ID of the teacher to retrieve.
     * @return The teacher with the specified ID.
     */
    @Override
    public Optional<Teacher> getTeacherByCode(String teacherId) {
        return teacherRepository.findByCodeOrIdentification(teacherId, teacherId).map(teacherEntityMapper::toModel);
    }

    /**
     * Creates a new teacher.
     *
     * @param teacher The teacher object to be created.
     */
    @Override
    public Optional<Teacher> createTeacher(Teacher teacher) {
        return teacherEntityMapper.toOptionalModel(teacherRepository.insert(teacherEntityMapper.toEntity(teacher)));
    }
}

