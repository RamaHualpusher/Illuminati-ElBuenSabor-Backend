package com.illuminati.ebs.dto;

import lombok.Data;

@Data
public class ProductoManufacturadoIngredienteDto {
    private Long idProductoManufacturadoIngrediente;
    private Long idProductoManufacturado;
    private Long idIngrediente;
    private Integer cantidad;
}
