package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.ProductoManufacturadoIngredienteDto;
import com.illuminati.ebs.entity.ProductoManufacturado_Ingrediente;
import org.springframework.stereotype.Component;

@Component
public class ProductoManufacturadoIngredienteMapper implements GenericMapper<ProductoManufacturadoIngredienteDto, ProductoManufacturado_Ingrediente> {

    @Override
    public ProductoManufacturado_Ingrediente toEntity(ProductoManufacturadoIngredienteDto dto) {
        ProductoManufacturado_Ingrediente entity = new ProductoManufacturado_Ingrediente();
        entity.setId(dto.getIdProductoManufacturadoIngrediente());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public ProductoManufacturadoIngredienteDto toDto(ProductoManufacturado_Ingrediente entity) {
        ProductoManufacturadoIngredienteDto dto = new ProductoManufacturadoIngredienteDto();
        dto.setIdProductoManufacturadoIngrediente(entity.getId());
        // Asigna los valores restantes...

        return dto;
    }
}
