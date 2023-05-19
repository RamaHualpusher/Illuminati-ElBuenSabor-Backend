package com.illuminati.ebs.dto;
import lombok.Data;

@Data
public class ProductoBebidaDto {
    private Long idProductoBebida;
    private String nombre;
    private String descripcion;
    private Integer stockMin;
    private ArticuloDto articulo;
}
