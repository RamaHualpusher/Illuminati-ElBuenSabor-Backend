package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.RolDto;
import com.illuminati.ebs.entity.Rol;
import org.springframework.stereotype.Component;

@Component
public class RolMapper implements GenericMapper<RolDto, Rol> {

    @Override
    public Rol toEntity(RolDto dto) {
        Rol entity = new Rol();
        entity.setId(dto.getIdRol());
        entity.setNombreRol(dto.getNombreRol());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public RolDto toDto(Rol entity) {
        RolDto dto = new RolDto();
        dto.setIdRol(entity.getId());
        dto.setNombreRol(entity.getNombreRol());
        // Asigna los valores restantes...

        return dto;
    }
}
