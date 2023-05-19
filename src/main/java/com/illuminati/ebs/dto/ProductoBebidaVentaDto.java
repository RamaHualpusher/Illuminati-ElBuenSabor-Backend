package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.Date;

@Data
public class ProductoBebidaVentaDto {
    private Long idProductoBebidaVenta;
    private Integer cantidad;
    private Date fecha;
    private ProductoBebidaDto productoBebida;
    private Double precioVenta;
}
