package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.Date;

@Data
public class ProductoManufacturadoCostoDto {
    private Long idProductoManufacturadoCosto;
    private Double precioCosto;
    private Integer cantidad;
    private Date fecha;
    private Long idProductoManufacturado;
}