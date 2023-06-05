package com.illuminati.ebs.dto;

import com.illuminati.ebs.entity.Pedido;
import lombok.Data;

@Data
public class DetallePedidoDto {
    private Long idDetallePedido;
    private Integer cantidad;
    private Double subtotal;
    private ArticuloDto articulo;
    private Pedido pedido;
    private ProductoManufacturadoDto productoManufacturado;
}