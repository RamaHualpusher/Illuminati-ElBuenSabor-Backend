package com.illuminati.ebs.dto;

import lombok.Data;

@Data
public class DetallePedidoDto {
    private Long idDetallePedido;
    private Integer cantidad;
    private Double subtotal;
    private Long idArticulo;
    private Long idPedido;
    private Long idProductoManufacturado;
}