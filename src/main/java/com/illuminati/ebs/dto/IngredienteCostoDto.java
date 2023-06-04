package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.Date;

@Data
public class IngredienteCostoDto {
    private Long idIngredienteCosto;
    private Double costo;
    private Date fecha;
    private Long idIngrediente;
}
