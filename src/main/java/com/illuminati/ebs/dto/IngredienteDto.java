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
    private Long idRubro;
    private List<Long> ingredientesCostoIds;
    private List<Long> ingredientesStockActualIds;
    private Long idUnidadMedida;
    private List<Long> productosManufacturadosIngredientesIds;
}
