package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PedidoDto {
    private Long idPedido;
    private Integer numeroPedido;
    private Date horaEstimadaFin;
    private String tipoEnvio;
    private Date fecha;
    private EstadoPedidoDto estadoPedido;
    private TipoEntregaPedidoDto tipoEntregaPedido;
    private TipoPagoDto tipoPago;
    private UsuarioDto usuario;
    private List<DetallePedidoDto> detallesPedidos;
}