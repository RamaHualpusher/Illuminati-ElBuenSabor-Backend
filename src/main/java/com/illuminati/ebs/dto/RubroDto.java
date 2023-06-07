package com.illuminati.ebs.dto;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idRubro")
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
