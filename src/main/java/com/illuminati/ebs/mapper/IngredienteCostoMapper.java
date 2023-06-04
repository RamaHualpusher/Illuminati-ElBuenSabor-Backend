package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.IngredienteCostoDto;
import com.illuminati.ebs.entity.IngredienteCosto;
import org.springframework.stereotype.Component;

@Component
public class IngredienteCostoMapper implements GenericMapper<IngredienteCostoDto, IngredienteCosto> {

    @Override
    public IngredienteCosto toEntity(IngredienteCostoDto dto) {
        IngredienteCosto entity = new IngredienteCosto();
        entity.setId(dto.getIdIngredienteCosto());
        entity.setCosto(dto.getCosto());
        entity.setFecha(dto.getFecha());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public IngredienteCostoDto toDto(IngredienteCosto entity) {
        IngredienteCostoDto dto = new IngredienteCostoDto();
        dto.setIdIngredienteCosto(entity.getId());
        dto.setCosto(entity.getCosto());
        dto.setFecha(entity.getFecha());
        // Asigna los valores restantes...

        return dto;
    }
}
