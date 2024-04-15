package org.simexmax.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.simexmax.dto.course.GradeDto;
import org.simexmax.model.course.Grade;

import java.util.List;
import java.util.Optional;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Mapper(componentModel = "spring")
public interface GradeDtoMapper {
    GradeDtoMapper INSTANCE = Mappers.getMapper(GradeDtoMapper.class);

    default GradeDto toDto(Grade model) {
        return model == null ? null : GradeDto.builder()
                .grade(model.getGrade())
                .weighting(model.getWeighting())
                .period(model.getPeriod())
                .student(StudentDtoMapper.INSTANCE.toDto(model.getStudent()))
                .subject(SubjectDtoMapper.INSTANCE.toDto(model.getSubject()))
                .build();
    }

    default Grade toModel(GradeDto dto) {
        return dto == null ? null : Grade.builder()
                .grade(dto.getGrade())
                .weighting(dto.getWeighting())
                .period(dto.getPeriod())
                .student(StudentDtoMapper.INSTANCE.toModel(dto.getStudent()))
                .subject(SubjectDtoMapper.INSTANCE.toModel(dto.getSubject()))
                .build();
    }

    default Optional<GradeDto> toOptionalDto(Grade model) {
        return Optional.ofNullable(toDto(model));
    }


    default Optional<Grade> toOptionalModel(GradeDto dto) {
        return Optional.ofNullable(toModel(dto));
    }

    List<GradeDto> toDtoList(List<Grade> models);

    List<Grade> toModelList(List<GradeDto> dtoList);
}
