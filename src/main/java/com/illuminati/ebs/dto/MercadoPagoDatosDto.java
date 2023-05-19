package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.Date;

@Data
public class MercadoPagoDatosDto {
    private Long idMercadoPagoData;
    private Integer identificadorPago;
    private Date fechaCreacion;
    private Date fechaAprobacion;
    private String formaPago;
    private String metodoPago;
    private String numTarjeta;
    private String estado;
}
