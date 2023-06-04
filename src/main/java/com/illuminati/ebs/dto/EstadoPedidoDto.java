package com.illuminati.ebs.dto;
import lombok.Data;

@Data
public class EstadoPedidoDto {
    private Long idEstadoPedido;
    private String descripcion;
    private String tiempo;
}