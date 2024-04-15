package org.simexmax.adapters.driven.mongodb.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.simexmax.adapters.driven.mongodb.entities.person.IdentificationEntity;
import org.simexmax.model.person.Identification;

import java.util.List;
import java.util.Optional;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@Mapper(componentModel = "spring")
public interface IdentificationEntityMapper {
    IdentificationEntityMapper INSTANCE = Mappers.getMapper(IdentificationEntityMapper.class);

    default Identification toModel(IdentificationEntity entity) {
        return entity == null ? null : Identification.builder()
                .number(entity.getNumber())
                .issueDate(entity.getIssueDate())
                .validFromDate(entity.getValidFromDate())
                .expirationDate(entity.getExpirationDate())
                .isActive(entity.getIsActive())
                .type(IdentificationTypeEntityMapper.INSTANCE.toModel(entity.getType()))
                .build();
    }

    default IdentificationEntity toEntity(Identification model) {
        return model == null ? null : IdentificationEntity.builder()
                .number(model.getNumber())
                .issueDate(model.getIssueDate())
                .validFromDate(model.getValidFromDate())
                .expirationDate(model.getExpirationDate())
                .isActive(model.isActive())
                .type(IdentificationTypeEntityMapper.INSTANCE.toEntity(model.getType()))
                .build();
    }

    default Optional<Identification> toOptionalModel(IdentificationEntity entity) {
        return Optional.ofNullable(toModel(entity));
    }

    default Optional<IdentificationEntity> toOptionalEntity(Identification model) {
        return Optional.ofNullable(toEntity(model));
    }

    List<Identification> toModelList(List<IdentificationEntity> entities);

    List<IdentificationEntity> toEntityList(List<Identification> models);
}
