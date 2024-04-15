package org.simexmax.adapters.driven.mongodb.services;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */

import org.simexmax.adapters.driven.mongodb.entities.course.GradeEntity;
import org.simexmax.adapters.driven.mongodb.mappers.GradeEntityMapper;
import org.simexmax.adapters.driven.mongodb.repositories.GradeRepository;
import org.simexmax.adapters.driver.rest.exeptions.ElementNotFoundException;
import org.simexmax.model.course.Grade;
import org.simexmax.ports.out.IGradePersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class represents a service for managing grades.
 * It implements the IGradePersistencePort interface.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Service
public class GradeSpringJpaPersistenceAdapter implements IGradePersistencePort {
    private final GradeRepository gradeRepository;
    private final GradeEntityMapper gradeEntityMapper;

    public GradeSpringJpaPersistenceAdapter(GradeRepository gradeRepository, GradeEntityMapper gradeEntityMapper) {
        this.gradeRepository = gradeRepository;
        this.gradeEntityMapper = gradeEntityMapper;
    }

    /**
     * Retrieves a list of all grades.
     *
     * @return A list containing all grades.
     */
    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll().stream().map(gradeEntityMapper::toModel).collect(Collectors.toList());
    }

    /**
     * Retrieves a grade by its student and subject and period.
     *
     * @param studentId   The code or identification of the student.
     * @param subjectCode The code of the subject.
     * @param period      The code of the grade.
     * @return An {@link Optional} containing the grade if found, or empty if not found.
     */
    @Override
    public Optional<Grade> getGradeByStudentSubjectPeriod(String studentId, String subjectCode, Integer period) {
        return gradeRepository.findByStudentSubjectPeriod(studentId, subjectCode, period).map(gradeEntityMapper::toModel);
    }

    /**
     * Retrieves all grade by its student and subject.
     *
     * @param studentId   The code or identification of the student.
     * @param subjectCode The code of the subject.
     * @return An {@link Optional} containing the grade if found, or empty if not found.
     */
    @Override
    public List<Grade> getAllStudentGradesBySubject(String studentId, String subjectCode) {
        return gradeRepository.findAllStudentGradesBySubject(studentId, subjectCode).stream()
                .map(gradeEntityMapper::toModel).collect(Collectors.toList());
    }

    /**
     * Create a new grade.
     *
     * @param grade The grade to be updated.
     */
    @Override
    public Optional<Grade> createGrade(Grade grade) {
        return gradeEntityMapper.toOptionalModel(gradeRepository.insert(gradeEntityMapper.toEntity(grade)));
    }

    /**
     * Update an existing grade.
     *
     * @param grade The grade to be updated.
     */
    @Override
    public Optional<Grade> updateGrade(Grade grade) {
        return gradeRepository.findByStudentSubjectPeriod(grade.getStudent().getCode(), grade.getSubject().getCode(),
                        grade.getPeriod())
                .map(gradeFound -> {
                    GradeEntity entity = gradeEntityMapper.toEntity(grade);
                    entity.setID(gradeFound.getID());
                    return gradeEntityMapper.toOptionalModel(gradeRepository.save(entity));
                })
                .orElse(Optional.empty());
    }

    /**
     * Delete an existing grade.
     *
     * @param grade The grade to be updated.
     */
    @Override
    public void deleteGrade(Grade grade) {
        gradeRepository.findByStudentSubjectPeriod(grade.getStudent().getCode(), grade.getSubject().getCode(),
                        grade.getPeriod())
                .ifPresentOrElse(gradeFound -> gradeRepository.deleteById(gradeFound.getID()),
                        () -> {
                            throw new ElementNotFoundException(50, "Grade not found");
                        });
    }
}

