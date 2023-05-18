package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Table(name = "ProductoBebida")
@AttributeOverride(name = "id", column = @Column(name = "id_producto_bebida"))
@Data
public class ProductoBebida  extends Base {
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "stock_minimo")
    private Integer stockMinumo;

    @OneToMany(mappedBy = "productoBebida", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProductoBebidaVenta> productosBebidasVentas;
    @OneToMany(mappedBy = "productoBebida", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProductoBebidaStockActual> productosBebidasStockActual;
    @OneToMany(mappedBy = "productoBebida", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProductoBebidaCosto> productosBebidasCosto;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_articulo")
    Articulo articulo;
}
