package com.illuminati.ebs.dto;

import lombok.Data;

@Data
public class ProductoManufacturadoIngredienteDto {
    private Long idProductoManufacturadoIngrediente;
    private ProductoManufacturadoDto productoManufacturado;
    private IngredienteDto ingrediente;
    private Integer cantidad;
}
