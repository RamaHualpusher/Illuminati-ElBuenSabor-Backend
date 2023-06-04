package com.illuminati.ebs.mapper;


import com.illuminati.ebs.dto.ProductoManufacturadoCostoDto;
import com.illuminati.ebs.entity.ProductoManufacturadoCosto;
import org.springframework.stereotype.Component;

@Component
public class ProductoManufacturadoCostoMapper implements GenericMapper<ProductoManufacturadoCostoDto, ProductoManufacturadoCosto> {

    @Override
    public ProductoManufacturadoCosto toEntity(ProductoManufacturadoCostoDto dto) {
        ProductoManufacturadoCosto entity = new ProductoManufacturadoCosto();
        entity.setId(dto.getIdProductoManufacturadoCosto());
        entity.setPrecioCosto(dto.getPrecioCosto());
        entity.setCantidad(dto.getCantidad());
        entity.setFecha(dto.getFecha());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public ProductoManufacturadoCostoDto toDto(ProductoManufacturadoCosto entity) {
        ProductoManufacturadoCostoDto dto = new ProductoManufacturadoCostoDto();
        dto.setIdProductoManufacturadoCosto(entity.getId());
        dto.setPrecioCosto(entity.getPrecioCosto());
        dto.setCantidad(entity.getCantidad());
        dto.setFecha(entity.getFecha());
        // Asigna los valores restantes...

        return dto;
    }
}
