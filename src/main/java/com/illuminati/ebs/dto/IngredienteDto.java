package com.illuminati.ebs.dto;
import lombok.Data;

@Data
public class IngredienteDto {
    private Long idIngrediente;
    private String nombre;
    private boolean estado;
    private Integer stockMinimo;
    private Integer stockActual;
}
