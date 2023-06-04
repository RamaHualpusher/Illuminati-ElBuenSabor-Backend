package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.Date;
@Data
public class ProductoManufacturadoVentaDto {
    private Long idProductoManufacturadoVenta;
    private Double precioVenta;
    private Integer cantidad;
    private Date fecha;
    private Long idProductoManufacturado;
}