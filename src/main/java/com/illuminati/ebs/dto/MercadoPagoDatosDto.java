package com.illuminati.ebs.dto;
import com.illuminati.ebs.entity.Pedido;
import lombok.Data;

import java.util.Date;

@Data
public class MercadoPagoDatosDto {
    private Long id;
    private Integer identificadorPago;
    private Date fechaCreacion;
    private Date fechaAprobacion;
    private String formaPago;
    private String metodoPago;
    private String numTarjeta;
    private String estado;
    private PedidoDto pedido;
}