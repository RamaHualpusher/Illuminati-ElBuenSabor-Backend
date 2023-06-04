package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.RubroDto;
import com.illuminati.ebs.entity.Rubro;
import org.springframework.stereotype.Component;

@Component
public class RubroMapper implements GenericMapper<RubroDto, Rubro> {

    @Override
    public Rubro toEntity(RubroDto dto) {
        Rubro entity = new Rubro();
        entity.setId(dto.getIdRubro());
        entity.setNombre(dto.getNombre());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public RubroDto toDto(Rubro entity) {
        RubroDto dto = new RubroDto();
        dto.setIdRubro(entity.getId());
        dto.setNombre(entity.getNombre());
        // Asigna los valores restantes...

        return dto;
    }
}
