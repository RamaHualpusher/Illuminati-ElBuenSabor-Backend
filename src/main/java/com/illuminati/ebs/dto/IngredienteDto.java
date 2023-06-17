package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.List;

@Data
public class IngredienteDto {
    private Long idIngrediente;
    private String nombre;
    private Boolean estado;
    private Integer stockMinimo;
    private Integer stockActual;
    private String unidadMedida;
    private RubroDto rubro;
    private List<ProductoIngredienteDto> productosIngredientes;
}
