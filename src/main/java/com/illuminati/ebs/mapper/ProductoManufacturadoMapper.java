package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.ProductoManufacturadoDto;
import com.illuminati.ebs.entity.ProductoManufacturado;
import org.springframework.stereotype.Component;

@Component
public class ProductoManufacturadoMapper implements GenericMapper<ProductoManufacturadoDto, ProductoManufacturado> {

    @Override
    public ProductoManufacturado toEntity(ProductoManufacturadoDto dto) {
        ProductoManufacturado entity = new ProductoManufacturado();
        entity.setId(dto.getIdProductoManufacturado());
        entity.setNombre(dto.getNombre());
        entity.setTiempoEstimadoCocina(dto.getTiempoEstimadoCocina());
        entity.setDenominacion(dto.getDenominacion());
        entity.setImagen(dto.getImagen());
        entity.setStockMinimo(dto.getStockMinimo());
        entity.setStockActual(dto.getStockActual());
        entity.setPreparacion(dto.getPreparacion());
        entity.setRubro(rubroMapper.toEntity(dto.getRubro()));  // suponiendo que tienes un RubroMapper
        // Aquí deberías manejar las listas de ids de manera adecuada.
        return entity;
    }

    @Override
    public ProductoManufacturadoDto toDto(ProductoManufacturado entity) {
        ProductoManufacturadoDto dto = new ProductoManufacturadoDto();
        dto.setIdProductoManufacturado(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setTiempoEstimadoCocina(entity.getTiempoEstimadoCocina());
        dto.setDenominacion(entity.getDenominacion());
        dto.setImagen(entity.getImagen());
        dto.setStockMinimo(entity.getStockMinimo());
        dto.setStockActual(entity.getStockActual());
        dto.setPreparacion(entity.getPreparacion());
        dto.setRubro(rubroMapper.toDto(entity.getRubro()));  // suponiendo que tienes un RubroMapper
        // Aquí deberías manejar las listas de ids de manera adecuada.
        return dto;
    }
}

