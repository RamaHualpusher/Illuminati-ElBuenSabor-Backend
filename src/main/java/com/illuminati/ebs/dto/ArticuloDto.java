package com.illuminati.ebs.dto;
import lombok.Data;

@Data
public class ArticuloDto {
    private Long idArticulo;
    private String denominacion;
    private Double precioCompra;
    private Double precioVenta;
    private Integer stockMinimo;
    private Integer stockActual;
    private Boolean esInsumo;
    private UnidadMedidaDto unidadMedida;

}
