package com.illuminati.ebs.dto;

import lombok.Data;
import java.util.List;

@Data
public class ProductoManufacturadoDto {
    private Long idProductoManufacturado;
    private String nombre;
    private Integer tiempoEstimadoCocina;
    private String denominacion;
    private String imagen;
    private Integer stockMinimo;
    private Integer stockActual;
    private String preparacion;
    private Long idRubro;
    private List<Long> detallePedidosIds;
    private List<Long> productosManufacturadosIngredientesIds;
    private List<Long> productosManufacturadosVentaIds;
    private List<Long> productosManufacturadosCostoIds;
}
