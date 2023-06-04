package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.ProductoBebidaCostoDto;
import com.illuminati.ebs.entity.ProductoBebidaCosto;
import org.springframework.stereotype.Component;

@Component
public class ProductoBebidaCostoMapper implements GenericMapper<ProductoBebidaCostoDto, ProductoBebidaCosto> {

    @Override
    public ProductoBebidaCosto toEntity(ProductoBebidaCostoDto dto) {
        ProductoBebidaCosto entity = new ProductoBebidaCosto();
        entity.setId(dto.getIdProductoBebidaCosto());
        entity.setCosto(dto.getCosto());
        entity.setFecha(dto.getFecha());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public ProductoBebidaCostoDto toDto(ProductoBebidaCosto entity) {
        ProductoBebidaCostoDto dto = new ProductoBebidaCostoDto();
        dto.setIdProductoBebidaCosto(entity.getId());
        dto.setCosto(entity.getCosto());
        dto.setFecha(entity.getFecha());
        // Asigna los valores restantes...

        return dto;
    }
}
