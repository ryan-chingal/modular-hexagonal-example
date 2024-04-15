package org.simexmax.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.simexmax.dto.course.SubjectDto;
import org.simexmax.model.course.Subject;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Mapper(componentModel = "spring")
public interface SubjectDtoMapper {
    SubjectDtoMapper INSTANCE = Mappers.getMapper(SubjectDtoMapper.class);

    default Subject toModel(SubjectDto dto) {
        return dto == null ? null : Subject.builder()
                .code(dto.getCode())
                .subjectName(dto.getSubjectName())
                .teacher(TeacherDtoMapper.INSTANCE.toModel(dto.getTeacher()))
                .exams(dto.getExamList().stream()
                        .map(GradeDtoMapper.INSTANCE::toModel)
                        .collect(Collectors.toList()))
                .build();
    }

    default SubjectDto toDto(Subject model) {
        return model == null ? null : SubjectDto.builder()
                .code(model.getCode())
                .subjectName(model.getSubjectName())
                .teacher(TeacherDtoMapper.INSTANCE.toDto(model.getTeacher()))
                .examList(model.getExamList().stream()
                        .map(GradeDtoMapper.INSTANCE::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

    default Optional<Subject> toOptionalModel(SubjectDto dto) {
        return Optional.ofNullable(dto).map(this::toModel);
    }

    default Optional<SubjectDto> toOptionalDto(Subject model) {
        return Optional.ofNullable(model).map(this::toDto);
    }

    List<SubjectDto> toDtoList(List<Subject> models);

    List<Subject> toModelList(List<SubjectDto> dtoList);
}
