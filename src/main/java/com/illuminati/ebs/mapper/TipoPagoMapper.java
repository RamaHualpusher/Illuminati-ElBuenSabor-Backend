package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.TipoPagoDto;
import com.illuminati.ebs.entity.TipoPago;
import org.springframework.stereotype.Component;

@Component
public class TipoPagoMapper implements GenericMapper<TipoPagoDto, TipoPago> {

    @Override
    public TipoPago toEntity(TipoPagoDto dto) {
        TipoPago entity = new TipoPago();
        entity.setId(dto.getIdTipoPago());
        entity.setDescripcion(dto.getDescripcion());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public TipoPagoDto toDto(TipoPago entity) {
        TipoPagoDto dto = new TipoPagoDto();
        dto.setIdTipoPago(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
        // Asigna los valores restantes...

        return dto;
    }
}
