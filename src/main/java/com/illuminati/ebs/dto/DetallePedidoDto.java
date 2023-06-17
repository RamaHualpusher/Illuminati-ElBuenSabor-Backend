package com.illuminati.ebs.dto;

import com.illuminati.ebs.entity.Pedido;
import lombok.Data;

@Data
public class DetallePedidoDto {
    private Long idDetallePedido;
    private Integer cantidad;
    private Double subtotal;
    private Pedido pedido;
    private ProductoDto producto;
}