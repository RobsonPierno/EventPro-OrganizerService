package com.eventpro.OrganizerService.utils;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eventpro.OrganizerService.dto.OrganizerDTO;
import com.eventpro.OrganizerService.model.Organizer;

@Mapper(componentModel = "spring", imports = com.eventpro.OrganizerService.enums.StatusEnum.class)
public interface OrganizerMapper {

    @Mapping(target = "status", expression = "java(dto.status() != null ? StatusEnum.valueOf(dto.status().toUpperCase()) : null)")
    Organizer toEntity(OrganizerDTO dto);

    @Mapping(target = "status", expression = "java(entity.getStatus() != null ? entity.getStatus().name() : null)")
    OrganizerDTO toDto(Organizer entity);
}
