package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.UnidadMedidaDto;
import com.illuminati.ebs.entity.UnidadMedida;
import org.springframework.stereotype.Component;

@Component
public class UnidadMedidaMapper implements GenericMapper<UnidadMedidaDto, UnidadMedida> {

    @Override
    public UnidadMedida toEntity(UnidadMedidaDto dto) {
        UnidadMedida entity = new UnidadMedida();
        entity.setId(dto.getIdUnidadMedida());
        entity.setDenominacion(dto.getDenominacion());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public UnidadMedidaDto toDto(UnidadMedida entity) {
        UnidadMedidaDto dto = new UnidadMedidaDto();
        dto.setIdUnidadMedida(entity.getId());
        dto.setDenominacion(entity.getDenominacion());
        // Asigna los valores restantes...

        return dto;
    }
}