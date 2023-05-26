package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.RolDto;
import com.illuminati.ebs.entity.Rol;
import org.springframework.stereotype.Component;

@Component
public class RolMapper implements GenericMapper<RolDto, Rol> {

    @Override
    public Rol toEntity(RolDto dto) {
        Rol entity = new Rol();
        // Set entity fields based on dto
        return entity;
    }

    @Override
    public RolDto toDto(Rol entity) {
        RolDto dto = new RolDto();
        // Set dto fields based on entity
        return dto;
    }
}
