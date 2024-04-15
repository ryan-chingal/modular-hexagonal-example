package org.simexmax.adapters.driven.mongodb.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.simexmax.adapters.driven.mongodb.entities.course.GradeEntity;
import org.simexmax.model.course.Grade;

import java.util.List;
import java.util.Optional;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Mapper(componentModel = "spring")
public interface GradeEntityMapper {
    GradeEntityMapper INSTANCE = Mappers.getMapper(GradeEntityMapper.class);

    default Grade toModel(GradeEntity entity) {
        return entity == null ? null : Grade.builder()
                .grade(entity.getGrade())
                .weighting(entity.getWeighting())
                .period(entity.getPeriod())
                .student(StudentEntityMapper.INSTANCE.toModel(entity.getStudent()))
                .subject(SubjectEntityMapper.INSTANCE.toModel(entity.getSubject()))
                .build();
    }

    default GradeEntity toEntity(Grade model) {
        return model == null ? null : GradeEntity.builder()
                .grade(model.getGrade())
                .weighting(model.getWeighting())
                .period(model.getPeriod())
                .student(StudentEntityMapper.INSTANCE.toEntity(model.getStudent()))
                .subject(SubjectEntityMapper.INSTANCE.toEntity(model.getSubject()))
                .build();
    }

    default Optional<Grade> toOptionalModel(GradeEntity entity) {
        return Optional.ofNullable(toModel(entity));
    }


    default Optional<GradeEntity> toOptionalEntity(Grade model) {
        return Optional.ofNullable(toEntity(model));
    }

    List<Grade> toModelList(List<GradeEntity> entities);

    List<GradeEntity> toEntityList(List<Grade> models);
}
