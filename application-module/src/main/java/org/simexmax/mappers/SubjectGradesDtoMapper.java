package org.simexmax.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.simexmax.dto.SubjectGradesDto;
import org.simexmax.model.course.SubjectGrades;

import java.util.List;
import java.util.Optional;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Mapper(componentModel = "spring")
public interface SubjectGradesDtoMapper {
    SubjectGradesDtoMapper INSTANCE = Mappers.getMapper(SubjectGradesDtoMapper.class);
    default SubjectGradesDto toDto(SubjectGrades model) {
        return model == null ? null : SubjectGradesDto.builder()
                .subject(SubjectDtoMapper.INSTANCE.toDto(model.getSubject()))
                .subjectGrades(GradeDtoMapper.INSTANCE.toDtoList(model.getSubjectGrades()))
                .build();
    }

    default SubjectGrades toModel(SubjectGradesDto dto) {
        return dto == null ? null : SubjectGrades.builder()
                .subject(SubjectDtoMapper.INSTANCE.toModel(dto.getSubject()))
                .subjectGrades(GradeDtoMapper.INSTANCE.toModelList(dto.getSubjectGrades()))
                .build();
    }

    default Optional<SubjectGradesDto> toOptionalDto(SubjectGrades model) {
        return Optional.ofNullable(toDto(model));
    }

    default Optional<SubjectGrades> toOptionalModel(SubjectGradesDto dto) {
        return Optional.ofNullable(toModel(dto));
    }

    List<SubjectGradesDto> toDtoList(List<SubjectGrades> entities);

    List<SubjectGrades> toModelList(List<SubjectGradesDto> dtoList);
}
