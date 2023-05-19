package com.illuminati.ebs.dto;
import lombok.Data;

@Data
public class RubroDto {
    private Long idRubro;
    private String nombre;
    private ArticuloDto articulo;
    private IngredienteDto ingrediente;
    private RubroDto rubroPadre;
    private ProductoManufacturadoDto productoManufacturado;
}
