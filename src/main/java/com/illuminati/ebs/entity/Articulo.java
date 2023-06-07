package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Articulo")
@AttributeOverride(name = "id", column = @Column(name = "id_articulo"))
@Data
public class Articulo extends Base {

    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "precio_compra")
    private Double precioCompra;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "stock_minimo")
    private Integer stockMinimo;

    @Column(name = "stock_actual")
    private Integer stockActual;

    @Column(name = "es_bebida")
    private Boolean esBebida;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetallePedido> detallesPedido;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductoBebidaCosto> productosBebidasCosto;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductoBebidaVenta> productosBebidasVenta;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductoBebidaStockActual> productosBebidasStockActual;

    @ManyToOne
    @JoinColumn(name = "id_rubro")
    private Rubro rubro;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedida unidadMedida;
}
