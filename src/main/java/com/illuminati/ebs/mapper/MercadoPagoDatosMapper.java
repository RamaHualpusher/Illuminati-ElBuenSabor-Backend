package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.MercadoPagoDatosDto;
import com.illuminati.ebs.entity.MercadoPagoDatos;
import org.springframework.stereotype.Component;

@Component
public class MercadoPagoDatosMapper implements GenericMapper<MercadoPagoDatosDto, MercadoPagoDatos> {

    @Override
    public MercadoPagoDatos toEntity(MercadoPagoDatosDto dto) {
        MercadoPagoDatos entity = new MercadoPagoDatos();
        entity.setId(dto.getIdMercadoPagoDatos());
        entity.setIdentificadorPago(dto.getIdentificadorPago());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setFechaAprobacion(dto.getFechaAprobacion());
        entity.setFormaPago(dto.getFormaPago());
        entity.setMetodoPago(dto.getMetodoPago());
        entity.setNumTarjeta(dto.getNumTarjeta());
        entity.setEstado(dto.getEstado());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public MercadoPagoDatosDto toDto(MercadoPagoDatos entity) {
        MercadoPagoDatosDto dto = new MercadoPagoDatosDto();
        dto.setIdMercadoPagoDatos(entity.getId());
        dto.setIdentificadorPago(entity.getIdentificadorPago());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaAprobacion(entity.getFechaAprobacion());
        dto.setFormaPago(entity.getFormaPago());
        dto.setMetodoPago(entity.getMetodoPago());
        dto.setNumTarjeta(entity.getNumTarjeta());
        dto.setEstado(entity.getEstado());
        // Asigna los valores restantes...

        return dto;
    }
}
