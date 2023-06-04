package com.illuminati.ebs.mapper;


import com.illuminati.ebs.dto.ProductoManufacturadoVentaDto;
import com.illuminati.ebs.entity.ProductoManufacturadoVenta;
import org.springframework.stereotype.Component;

@Component
public class ProductoManufacturadoVentaMapper implements GenericMapper<ProductoManufacturadoVentaDto, ProductoManufacturadoVenta> {

    @Override
    public ProductoManufacturadoVenta toEntity(ProductoManufacturadoVentaDto dto) {
        ProductoManufacturadoVenta entity = new ProductoManufacturadoVenta();
        entity.setId(dto.getIdProductoManufacturadoVenta());
        entity.setPrecioVenta(dto.getPrecioVenta());
        entity.setCantidad(dto.getCantidad());
        entity.setFecha(dto.getFecha());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public ProductoManufacturadoVentaDto toDto(ProductoManufacturadoVenta entity) {
        ProductoManufacturadoVentaDto dto = new ProductoManufacturadoVentaDto();
        dto.setIdProductoManufacturadoVenta(entity.getId());
        dto.setPrecioVenta(entity.getPrecioVenta());
        dto.setCantidad(entity.getCantidad());
        dto.setFecha(entity.getFecha());
        // Asigna los valores restantes...

        return dto;
    }
}
