package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.List;

@Data
public class RubroDto {
    private Long idRubro;
    private String nombre;
    private Long idRubroPadre;
    private List<Long> rubrosHijosIds;
    private List<Long> articulosIds;
    private List<Long> ingredientesIds;
    private List<Long> productoManufacturadoIds;
}
