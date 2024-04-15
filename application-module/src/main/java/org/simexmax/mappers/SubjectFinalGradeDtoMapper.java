package org.simexmax.mappers;

import org.mapstruct.factory.Mappers;
import org.simexmax.dto.SubjectFinalGradeDto;
import org.simexmax.model.course.SubjectFinalGrade;

import java.util.List;
import java.util.Optional;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public interface SubjectFinalGradeDtoMapper {
    SubjectFinalGradeDtoMapper INSTANCE = Mappers.getMapper(SubjectFinalGradeDtoMapper.class);

    default SubjectFinalGradeDto toDto(SubjectFinalGrade model) {
        return model == null ? null : SubjectFinalGradeDto.builder()
                .finalGrade(model.getFinalGrade())
                .subject(SubjectDtoMapper.INSTANCE.toDto(model.getSubject()))
                .student(StudentDtoMapper.INSTANCE.toDto(model.getStudent()))
                .build();
    }

    default SubjectFinalGrade toModel(SubjectFinalGradeDto dto) {
        return dto == null ? null : SubjectFinalGrade.builder()
                .finalGrade(dto.getFinalGrade())
                .subject(SubjectDtoMapper.INSTANCE.toModel(dto.getSubject()))
                .student(StudentDtoMapper.INSTANCE.toModel(dto.getStudent()))
                .build();
    }

    default Optional<SubjectFinalGradeDto> toOptionalDto(SubjectFinalGrade model) {
        return Optional.ofNullable(toDto(model));
    }

    default Optional<SubjectFinalGrade> toOptionalModel(SubjectFinalGradeDto dto) {
        return Optional.ofNullable(toModel(dto));
    }

    List<SubjectFinalGradeDto> toDtoList(List<SubjectFinalGrade> entities);

    List<SubjectFinalGrade> toModelList(List<SubjectFinalGradeDto> dtoList);
}
