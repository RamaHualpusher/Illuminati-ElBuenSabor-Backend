package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.DomicilioDto;
import com.illuminati.ebs.entity.Domicilio;
import org.springframework.stereotype.Component;

@Component
public class DomicilioMapper implements GenericMapper<DomicilioDto, Domicilio> {

    @Override
    public Domicilio toEntity(DomicilioDto dto) {
        Domicilio entity = new Domicilio();
        entity.setId(dto.getIdDomicilio());
        entity.setCalle(dto.getCalle());
        entity.setNumero(dto.getNumero());
        entity.setLocalidad(dto.getLocalidad());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public DomicilioDto toDto(Domicilio entity) {
        DomicilioDto dto = new DomicilioDto();
        dto.setIdDomicilio(entity.getId());
        dto.setCalle(entity.getCalle());
        dto.setNumero(entity.getNumero());
        dto.setLocalidad(entity.getLocalidad());
        // Asigna los valores restantes...

        return dto;
    }
}