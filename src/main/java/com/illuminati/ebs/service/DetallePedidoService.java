package com.illuminati.ebs.service;

import com.illuminati.ebs.entity.DetallePedido;
import com.illuminati.ebs.entity.Producto;
import com.illuminati.ebs.exception.ServiceException;

import java.util.List;

public interface DetallePedidoService extends GenericService<DetallePedido, Long>{
    List<DetallePedido> findDetallesPedidoByPedidoId(Long pedidoId);
}
