package org.simexmax.adapters.driven.mongodb.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.simexmax.adapters.driven.mongodb.entities.person.IdentificationTypeEntity;
import org.simexmax.model.person.IdentificationType;

import java.util.List;
import java.util.Optional;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Mapper(componentModel = "spring")
public interface IdentificationTypeEntityMapper {
    IdentificationTypeEntityMapper INSTANCE = Mappers.getMapper(IdentificationTypeEntityMapper.class);

    IdentificationType toModel(IdentificationTypeEntity entity);

    IdentificationTypeEntity toEntity(IdentificationType model);

    default Optional<IdentificationType> toOptionalDto(IdentificationTypeEntity entity) {
        return Optional.ofNullable(toModel(entity));
    }

    default Optional<IdentificationTypeEntity> toOptionalEntity(IdentificationType model) {
        return Optional.ofNullable(toEntity(model));
    }

    List<IdentificationType> toModelList(List<IdentificationTypeEntity> entities);

    List<IdentificationTypeEntity> toEntityList(List<IdentificationType> models);
}
