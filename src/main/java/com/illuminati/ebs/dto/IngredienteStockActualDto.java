package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.Date;

@Data
public class IngredienteStockActualDto {
    private Long idIngredienteStockActual;
    private Integer stockActual;
    private Date fecha;
    private IngredienteDto ingrediente;
}
