package com.illuminati.ebs.dto;
import lombok.Data;

@Data
public class EstadoPedidoDto {
    private Long idOrderStatus;
    private String descripcion;
    private String tiempo;
}
