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
    private Long idEstadoPedido;
    private Long idTipoEntregaPedido;
    private Long idTipoPago;
    private Long idUsuario;
    private List<Long> detallesPedidosIds;
}