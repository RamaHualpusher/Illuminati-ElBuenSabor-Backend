package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.Date;

@Data
public class ProductoBebidaVentaDto {
    private Long idProductoBebidaVenta;
    private Integer cantidad;
    private Double precioVenta;
    private Date fecha;
    private ArticuloDto articulo;
}
