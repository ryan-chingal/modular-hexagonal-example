package org.simexmax.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.simexmax.dto.person.StudentDto;
import org.simexmax.model.person.Identification;
import org.simexmax.model.person.IdentificationType;
import org.simexmax.model.person.Student;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Mapper(componentModel = "spring")
public interface StudentDtoMapper {
    StudentDtoMapper INSTANCE = Mappers.getMapper(StudentDtoMapper.class);

    default StudentDto toDto(Student model) {
        return model == null ? null : StudentDto.builder()
                .code(model.getCode())
                .userName(model.getUserName())
                .firstName(model.getFirstName())
                .secondName(model.getSecondName())
                .firstLastname(model.getFirstLastname())
                .secondLastname(model.getSecondLastname())
                .email(model.getEmail())
                .password(model.getPassword())
                .birthDate(model.getBirthDate())
                .identification(model.getIdentificationList().stream()
                        .filter(Identification::isActive)
                        .findFirst()
                        .map(Identification::getNumber)
                                .orElse("")
                        )
                .identificationType(model.getIdentificationList().stream()
                        .filter(Identification::isActive)
                        .findFirst()
                        .map(identification ->  identification.getType().getDescription())
                        .orElse("")
                )
                .build();
    }

    default Student toModel(StudentDto dto) {
        return dto == null ? null : Student.builder()
                .code(dto.getCode())
                .userName(dto.getUserName())
                .firstName(dto.getFirstName())
                .secondName(dto.getSecondName())
                .firstLastname(dto.getFirstLastname())
                .secondLastname(dto.getSecondLastname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .birthDate(dto.getBirthDate())
                .identification(Identification.builder()
                        .number(dto.getIdentification())
                        .type(IdentificationType.builder()
                                .name(dto.getIdentificationType())
                                .description(dto.getIdentificationDescription())
                                .initials(dto.getIdentificationInitials())
                                .build())
                        .build())
                .build();
    }

    default Optional<StudentDto> toOptionalDto(Student model) {
        return Optional.ofNullable(toDto(model));
    }

    default Optional<Student> toOptionalModel(StudentDto dto) {
        return Optional.ofNullable(toModel(dto));
    }

    List<StudentDto> toDtoList(List<Student> models);

    List<Student> toModelList(List<StudentDto> dtoList);
}
