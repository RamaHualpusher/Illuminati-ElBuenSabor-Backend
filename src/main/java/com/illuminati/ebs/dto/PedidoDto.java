package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PedidoDto {
    private Long id;
    private Integer numeroPedido;
    private Date horaEstimadaFin;
    private boolean esDelivery;
    private boolean esEfectivo;
    private String estadoPedido;
    private Date fechaPedido;
    private Double total;
    private UsuarioDto usuario;
    private List<DetallePedidoDto> detallesPedidos;
    private MercadoPagoDatosDto mercadoPagoDatos;
}