package com.illuminati.ebs.dto;

import lombok.Data;

@Data
public class ProductoIngredienteDto {
    private Long id;
    private ProductoDto producto;
    private IngredienteDto ingrediente;
    private Integer cantidad;
}
