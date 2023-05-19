package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.Date;

@Data
public class IngredienteCostoDto {
    private Long idIngredientesCosto;
    private Double costo;
    private Date fecha;
    private IngredienteDto ingrediente;
}
