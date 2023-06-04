package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.ProductoBebidaVentaDto;
import com.illuminati.ebs.entity.ProductoBebidaVenta;
import org.springframework.stereotype.Component;

@Component
public class ProductoBebidaVentaMapper implements GenericMapper<ProductoBebidaVentaDto, ProductoBebidaVenta> {

    @Override
    public ProductoBebidaVenta toEntity(ProductoBebidaVentaDto dto) {
        ProductoBebidaVenta entity = new ProductoBebidaVenta();
        entity.setId(dto.getIdProductoBebidaVenta());
        entity.setCantidad(dto.getCantidad());
        entity.setPrecioVenta(dto.getPrecioVenta());
        entity.setFecha(dto.getFecha());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public ProductoBebidaVentaDto toDto(ProductoBebidaVenta entity) {
        ProductoBebidaVentaDto dto = new ProductoBebidaVentaDto();
        dto.setIdProductoBebidaVenta(entity.getId());
        dto.setCantidad(entity.getCantidad());
        dto.setPrecioVenta(entity.getPrecioVenta());
        dto.setFecha(entity.getFecha());
        // Asigna los valores restantes...

        return dto;
    }
}