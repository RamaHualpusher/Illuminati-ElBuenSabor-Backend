package com.illuminati.ebs.dto;

import lombok.Data;
import java.util.List;

@Data
public class ProductoDto {
    private Long idProducto;
    private String nombre;
    private Integer tiempoEstimadoCocina;
    private String denominacion;
    private String imagen;
    private Integer stockMinimo;
    private Integer stockActual;
    private String preparacion;
    private Double precio;
    private Boolean esBebida;
    private RubroDto rubro;
    private List<DetallePedidoDto> detallePedidos;
    private List<ProductoIngredienteDto> productosManufacturadosIngredientes;

}
