package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.ProductoBebidaStockActualDto;
import com.illuminati.ebs.entity.ProductoBebidaStockActual;
import org.springframework.stereotype.Component;

@Component
public class ProductoBebidaStockActualMapper implements GenericMapper<ProductoBebidaStockActualDto, ProductoBebidaStockActual> {

    @Override
    public ProductoBebidaStockActual toEntity(ProductoBebidaStockActualDto dto) {
        ProductoBebidaStockActual entity = new ProductoBebidaStockActual();
        entity.setId(dto.getIdProductoBebidaStockActual());
        entity.setStockActual(dto.getStockActual());
        entity.setFecha(dto.getFecha());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public ProductoBebidaStockActualDto toDto(ProductoBebidaStockActual entity) {
        ProductoBebidaStockActualDto dto = new ProductoBebidaStockActualDto();
        dto.setIdProductoBebidaStockActual(entity.getId());
        dto.setStockActual(entity.getStockActual());
        dto.setFecha(entity.getFecha());
        // Asigna los valores restantes...

        return dto;
    }
}