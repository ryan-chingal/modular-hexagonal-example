package org.simexmax.adapters.driven.mongodb.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.simexmax.adapters.driven.mongodb.entities.person.StudentEntity;
import org.simexmax.dto.person.StudentDto;
import org.simexmax.model.person.Student;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Mapper(componentModel = "spring")
public interface StudentEntityMapper {
    StudentEntityMapper INSTANCE = Mappers.getMapper(StudentEntityMapper.class);

    default Student toModel(StudentEntity entity) {
        return entity == null ? null : Student.builder()
                .code(entity.getCode())
                .userName(entity.getUserName())
                .firstName(entity.getFirstName())
                .secondName(entity.getSecondName())
                .firstLastname(entity.getFirstLastname())
                .secondLastname(entity.getSecondLastname())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .birthDate(entity.getBirthDate())
                .identificationList(entity.getIdentificationList().stream()
                        .map(IdentificationEntityMapper.INSTANCE::toModel)
                        .collect(Collectors.toList()))
                .enrolledSubjects(entity.getEnrolledSubjects().stream()
                        .map(SubjectEntityMapper.INSTANCE::toModel)
                        .collect(Collectors.toList()))
                .build();
    }

    default StudentEntity toEntity(Student model) {
        return model == null ? null : StudentEntity.builder()
                .code(model.getCode())
                .userName(model.getUserName())
                .firstName(model.getFirstName())
                .secondName(model.getSecondName())
                .firstLastname(model.getFirstLastname())
                .secondLastname(model.getSecondLastname())
                .email(model.getEmail())
                .password(model.getPassword())
                .birthDate(model.getBirthDate())
                .identificationList(model.getIdentificationList().stream()
                        .map(IdentificationEntityMapper.INSTANCE::toEntity)
                        .collect(Collectors.toList()))
                .enrolledSubjects(model.getEnrolledSubjects().stream()
                        .map(SubjectEntityMapper.INSTANCE::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    default Optional<Student> toOptionalModel(StudentEntity entity) {
        return Optional.ofNullable(toModel(entity));
    }

    default Optional<StudentEntity> toOptionalEntity(Student model) {
        return Optional.ofNullable(toEntity(model));
    }

    List<Student> toModelList(List<StudentEntity> entity);

    List<StudentEntity> toEntityList(List<StudentDto> models);
}
