package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.IngredienteDto;
import com.illuminati.ebs.entity.Ingrediente;
import org.springframework.stereotype.Component;

@Component
public class IngredienteMapper implements GenericMapper<IngredienteDto, Ingrediente> {

    @Override
    public Ingrediente toEntity(IngredienteDto dto) {
        Ingrediente entity = new Ingrediente();
        entity.setId(dto.getIdIngrediente());
        entity.setNombre(dto.getNombre());
        entity.setEstado(dto.getEstado());
        entity.setStockMinimo(dto.getStockMinimo());
        entity.setStockActual(dto.getStockActual());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public IngredienteDto toDto(Ingrediente entity) {
        IngredienteDto dto = new IngredienteDto();
        dto.setIdIngrediente(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setEstado(entity.getEstado());
        dto.setStockMinimo(entity.getStockMinimo());
        dto.setStockActual(entity.getStockActual());
        // Asigna los valores restantes...

        return dto;
    }
}
