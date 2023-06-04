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
    private Long idRubro;
    private Long idUnidadMedida;
    private List<Long> detallesPedidoIds;
    private List<Long> productosBebidasCostoIds;
    private List<Long> productosBebidasVentaIds;
    private List<Long> productosBebidasStockActualIds;
}
