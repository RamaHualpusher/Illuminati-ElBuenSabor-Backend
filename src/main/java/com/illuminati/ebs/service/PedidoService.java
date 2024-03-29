package com.illuminati.ebs.service;

import com.illuminati.ebs.dto.PedidoDto;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.entity.Producto;
import com.illuminati.ebs.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface PedidoService extends GenericService<Pedido, Long>{
    List<Pedido> findPedidosByUsuarioId(Long usuarioId);

    public Optional<PedidoDto> getPedidoCompletoById(Long pedidoId);
    List<Pedido> findPedidosByEstado(String estadoPedido);
}
