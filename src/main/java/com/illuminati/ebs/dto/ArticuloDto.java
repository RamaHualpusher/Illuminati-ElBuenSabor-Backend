package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.List;

@Data
public class ArticuloDto {
    private Long idArticulo;
    private String denominacion;
    private Double precioCompra;
    private Double precioVenta;
    private Integer stockMinimo;
    private Integer stockActual;
    private Boolean esBebida;
    private Long rubroId; // Cambio: ID del rubro existente
    private Long unidadMedidaId; // Cambio: ID de la unidad de medida existente
    // Eliminamos las listas relacionadas a ProductoBebidaVenta y otras que no se inicializarán en la creación del artículo
}
