package com.illuminati.ebs.dto;
import lombok.Data;

@Data
public class TipoPagoDto {
    private Long idTipoPago;
    private String descripcion;
    private MercadoPagoDatosDto mercadoPagoDatos;
}
