package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.DetallePedidoDto;
import com.illuminati.ebs.entity.DetallePedido;
import org.springframework.stereotype.Component;

@Component
public class DetallePedidoMapper implements GenericMapper<DetallePedidoDto, DetallePedido> {

    @Override
    public DetallePedido toEntity(DetallePedidoDto dto) {
        DetallePedido entity = new DetallePedido();
        entity.setId(dto.getIdDetallePedido());
        entity.setCantidad(dto.getCantidad());
        entity.setSubtotal(dto.getSubtotal());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public DetallePedidoDto toDto(DetallePedido entity) {
        DetallePedidoDto dto = new DetallePedidoDto();
        dto.setIdDetallePedido(entity.getId());
        dto.setCantidad(entity.getCantidad());
        dto.setSubtotal(entity.getSubtotal());
        // Asigna los valores restantes...

        return dto;
    }
}