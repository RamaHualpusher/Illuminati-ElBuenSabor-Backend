package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.PedidoDto;
import com.illuminati.ebs.entity.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper implements GenericMapper<PedidoDto, Pedido> {

    @Override
    public Pedido toEntity(PedidoDto dto) {
        Pedido entity = new Pedido();
        entity.setId(dto.getIdPedido());
        entity.setNumeroPedido(dto.getNumeroPedido());
        entity.setHoraEstimadaFin(dto.getHoraEstimadaFin());
        entity.setTipoEnvio(dto.getTipoEnvio());
        entity.setFecha(dto.getFecha());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public PedidoDto toDto(Pedido entity) {
        PedidoDto dto = new PedidoDto();
        dto.setIdPedido(entity.getId());
        dto.setNumeroPedido(entity.getNumeroPedido());
        dto.setHoraEstimadaFin(entity.getHoraEstimadaFin());
        dto.setTipoEnvio(entity.getTipoEnvio());
        dto.setFecha(entity.getFecha());
        // Asigna los valores restantes...

        return dto;
    }
}