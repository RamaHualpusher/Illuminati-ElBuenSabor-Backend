package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.List;

@Data
public class RubroDto {
    private Long idRubro;
    private String nombre;
    private RubroDto rubroPadre;
    private List<RubroDto> rubrosHijos;
    private List<ArticuloDto> articulos;
    private List<IngredienteDto> ingredientes;
    private List<ProductoBebidaCostoDto> productoManufacturado;
}
