package org.simexmax.adapters.driven.mongodb.services;

import org.simexmax.adapters.driven.mongodb.entities.person.StudentEntity;
import org.simexmax.adapters.driven.mongodb.mappers.StudentEntityMapper;
import org.simexmax.adapters.driven.mongodb.repositories.GenericPersonRepository;
import org.simexmax.model.person.Student;
import org.simexmax.ports.out.IStudentPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class represents a service for managing students.
 * It implements the IStudentPersistencePort interface.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Service
public class StudentSpringJpaAdapter implements IStudentPersistencePort {
    private final GenericPersonRepository<StudentEntity> studentRepository;
    private final StudentEntityMapper studentEntityMapper;

    public StudentSpringJpaAdapter(GenericPersonRepository<StudentEntity> studentRepository, StudentEntityMapper studentEntityMapper) {
        this.studentRepository = studentRepository;
        this.studentEntityMapper = studentEntityMapper;
    }

    /**
     * Retrieves a list of all students.
     *
     * @return A list of all students.
     */
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll().stream().map(studentEntityMapper::toModel).collect(Collectors.toList());
    }

    /**
     * Retrieves a student by their ID or code.
     *
     * @param studentId The ID or code of the student to retrieve.
     * @return The student with the specified ID or code.
     */
    @Override
    public Optional<Student> getStudentByCodeOrId(String studentId) {
        return studentRepository.findByCodeOrIdentification(studentId, studentId).map(studentEntityMapper::toModel);
    }

    /**
     * Creates a new student.
     *
     * @param student The student object to be created.
     */
    @Override
    public Optional<Student> createStudent(Student student) {
        return studentEntityMapper.toOptionalModel(studentRepository.insert(studentEntityMapper.toEntity(student)));
    }
}
