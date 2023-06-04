package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.ArticuloDto;
import com.illuminati.ebs.entity.Articulo;
import org.springframework.stereotype.Component;

@Component
public class ArticuloMapper implements GenericMapper<ArticuloDto, Articulo> {

    @Override
    public Articulo toEntity(ArticuloDto dto) {
        Articulo entity = new Articulo();
        entity.setId(dto.getIdArticulo());
        entity.setDenominacion(dto.getDenominacion());
        entity.setPrecioCompra(dto.getPrecioCompra());
        entity.setPrecioVenta(dto.getPrecioVenta());
        entity.setStockMinimo(dto.getStockMinimo());
        entity.setStockActual(dto.getStockActual());
        entity.setEsBebida(dto.getEsBebida());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public ArticuloDto toDto(Articulo entity) {
        ArticuloDto dto = new ArticuloDto();
        dto.setIdArticulo(entity.getId());
        dto.setDenominacion(entity.getDenominacion());
        dto.setPrecioCompra(entity.getPrecioCompra());
        dto.setPrecioVenta(entity.getPrecioVenta());
        dto.setStockMinimo(entity.getStockMinimo());
        dto.setStockActual(entity.getStockActual());
        dto.setEsBebida(entity.getEsBebida());
        // Asigna los valores restantes...

        return dto;
    }
}