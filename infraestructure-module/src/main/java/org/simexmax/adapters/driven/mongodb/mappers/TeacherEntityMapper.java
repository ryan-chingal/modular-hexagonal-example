package org.simexmax.adapters.driven.mongodb.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.simexmax.adapters.driven.mongodb.entities.person.TeacherEntity;
import org.simexmax.model.person.Teacher;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Mapper(componentModel = "spring")
public interface TeacherEntityMapper {
    TeacherEntityMapper INSTANCE = Mappers.getMapper(TeacherEntityMapper.class);
    default Teacher toModel(TeacherEntity entity) {
        return entity == null ? null : Teacher.builder()
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
                .subjectsTaught(entity.getSubjectsTaught().stream()
                        .map(SubjectEntityMapper.INSTANCE::toModel)
                        .collect(Collectors.toList()))
                .build();
    }

    default TeacherEntity toEntity(Teacher model) {
        return model == null ? null : TeacherEntity.builder()
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
                .subjectsTaught(model.getSubjectsTaught().stream()
                        .map(SubjectEntityMapper.INSTANCE::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    default Optional<Teacher> toOptionalModel(TeacherEntity entity) {
        return Optional.ofNullable(toModel(entity));
    }

    default Optional<TeacherEntity> toOptionalEntity(Teacher model) {
        return Optional.ofNullable(toEntity(model));
    }

    List<Teacher> toModelList(List<TeacherEntity> entities);

    List<TeacherEntity> toEntityList(List<Teacher> dtoList);

}
