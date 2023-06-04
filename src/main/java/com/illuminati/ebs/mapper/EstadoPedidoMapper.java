package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.EstadoPedidoDto;
import com.illuminati.ebs.entity.EstadoPedido;
import org.springframework.stereotype.Component;

@Component
public class EstadoPedidoMapper implements GenericMapper<EstadoPedidoDto, EstadoPedido> {

    @Override
    public EstadoPedido toEntity(EstadoPedidoDto dto) {
        EstadoPedido entity = new EstadoPedido();
        entity.setId(dto.getIdEstadoPedido());
        entity.setDescripcion(dto.getDescripcion());
        entity.setTiempo(dto.getTiempo());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public EstadoPedidoDto toDto(EstadoPedido entity) {
        EstadoPedidoDto dto = new EstadoPedidoDto();
        dto.setIdEstadoPedido(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
        dto.setTiempo(entity.getTiempo());
        // Asigna los valores restantes...

        return dto;
    }
}
