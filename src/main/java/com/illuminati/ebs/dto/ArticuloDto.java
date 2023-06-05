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
    private RubroDto rubro;
    private UnidadMedidaDto unidadMedida;
    private List<DetallePedidoDto> detallesPedido;
    private List<ProductoBebidaCostoDto> productosBebidasCosto;
    private List<ProductoBebidaVentaDto> productosBebidasVenta;
    private List<ProductoBebidaStockActualDto> productosBebidasStockActual;
}
