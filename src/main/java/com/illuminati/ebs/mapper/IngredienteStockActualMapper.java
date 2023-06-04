package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.IngredienteStockActualDto;
import com.illuminati.ebs.entity.IngredienteStockActual;
import org.springframework.stereotype.Component;

@Component
public class IngredienteStockActualMapper implements GenericMapper<IngredienteStockActualDto, IngredienteStockActual> {

    @Override
    public IngredienteStockActual toEntity(IngredienteStockActualDto dto) {
        IngredienteStockActual entity = new IngredienteStockActual();
        entity.setId(dto.getIdIngredienteStockActual());
        entity.setStockActual(dto.getStockActual());
        entity.setFecha(dto.getFecha());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public IngredienteStockActualDto toDto(IngredienteStockActual entity) {
        IngredienteStockActualDto dto = new IngredienteStockActualDto();
        dto.setIdIngredienteStockActual(entity.getId());
        dto.setStockActual(entity.getStockActual());
        dto.setFecha(entity.getFecha());
        // Asigna los valores restantes...

        return dto;
    }
}
