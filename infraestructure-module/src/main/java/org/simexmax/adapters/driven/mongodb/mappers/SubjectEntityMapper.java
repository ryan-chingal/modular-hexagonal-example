package org.simexmax.adapters.driven.mongodb.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.simexmax.adapters.driven.mongodb.entities.course.SubjectEntity;
import org.simexmax.model.course.Subject;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Mapper(componentModel = "spring")
public interface SubjectEntityMapper {
    SubjectEntityMapper INSTANCE = Mappers.getMapper(SubjectEntityMapper.class);
    default Subject toModel(SubjectEntity entity) {
        return entity == null ? null : Subject.builder()
                .code(entity.getCode())
                .subjectName(entity.getSubjectName())
                .teacher(TeacherEntityMapper.INSTANCE.toModel(entity.getTeacher()))
                .exams(entity.getExamList().stream()
                        .map(GradeEntityMapper.INSTANCE::toModel)
                        .collect(Collectors.toList()))
                .build();
    }

    default SubjectEntity toEntity(Subject model) {
        return model == null ? null : SubjectEntity.builder()
                .code(model.getCode())
                .subjectName(model.getSubjectName())
                .teacher(TeacherEntityMapper.INSTANCE.toEntity(model.getTeacher()))
                .examList(model.getExamList().stream()
                        .map(GradeEntityMapper.INSTANCE::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    default Optional<SubjectEntity> toOptionalEntity(Subject model) {
        return Optional.ofNullable(model).map(this::toEntity);
    }

    default Optional<Subject> toOptionalModel(SubjectEntity entity) {
        return Optional.ofNullable(entity).map(this::toModel);
    }

    List<Subject> toModelList(List<SubjectEntity> entities);

    List<SubjectEntity> toEntityList(List<Subject> dtoList);
}
