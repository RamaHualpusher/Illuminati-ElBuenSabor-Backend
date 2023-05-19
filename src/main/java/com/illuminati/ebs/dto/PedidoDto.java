package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PedidoDto {
    private Long idPedido;
    private Integer numeroPedido;
    private Date fechaPedido;
    private Date horaEstimadaFin;
    private String tipoEnvio;
    private TipoEntregaPedidoDto tipoEntregaPedido;
    private EstadoPedidoDto estadoPedido;
    private TipoPagoDto tipoPago;
    private UsuarioDto usuario;
    private ArticuloDto articulo;
}
