package com.illuminati.ebs.dto;

import lombok.Data;
import java.util.List;

@Data
public class ProductoManufacturadoDto {
    private Long idProductoManufacturado;
    private String nombre;
    private Integer tiempoEstimadoCocina;
    private String denominacion;
    private String imagen;
    private Integer stockActual;
    private Integer stockMinimo;
    private String preparacion;
    private List<IngredienteDto> ingredientes;
}
