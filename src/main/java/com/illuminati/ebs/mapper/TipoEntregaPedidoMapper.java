package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.TipoEntregaPedidoDto;
import com.illuminati.ebs.entity.TipoEntregaPedido;
import org.springframework.stereotype.Component;

@Component
public class TipoEntregaPedidoMapper implements GenericMapper<TipoEntregaPedidoDto, TipoEntregaPedido> {

    @Override
    public TipoEntregaPedido toEntity(TipoEntregaPedidoDto dto) {
        TipoEntregaPedido entity = new TipoEntregaPedido();
        entity.setId(dto.getIdTipoEntregaPedido());
        entity.setDescripcion(dto.getDescripcion());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public TipoEntregaPedidoDto toDto(TipoEntregaPedido entity) {
        TipoEntregaPedidoDto dto = new TipoEntregaPedidoDto();
        dto.setIdTipoEntregaPedido(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
        // Asigna los valores restantes...

        return dto;
    }
}