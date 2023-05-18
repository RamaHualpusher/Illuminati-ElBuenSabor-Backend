package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "ProductoManufacturado")
@AttributeOverride(name = "id", column = @Column(name = "id_producto_manufacturado"))
@Data
public class ProductoManufacturado extends Base{
    @Column(name = "nombre")
    String nombre;
    @Column(name = "tiempo_estimado_cocina")
    Integer tiempoEstimadoCocina;
    @Column(name = "denominacion")
    String denominacion;
    @Column(name = "imagen")
    String imagen;
    @Column(name = "stock_minimo")
    Integer stockMinimo;
    @Column(name = "stock_actual")
    Integer stockActual;
    @Column(name = "preparacion")
    String preparacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_articulo")
    Articulo articulo;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}
            , mappedBy = "productosManufacturados"
            ,targetEntity = Ingrediente.class
    )
    List<Ingrediente> ingredientes;

    @OneToMany(mappedBy = "productoManufacturado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProductoManufacturadoVenta> productosManufacturadosVenta;

    @OneToMany(mappedBy = "productoManufacturado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProductoManufacturadoCosto> productosManufacturadosCosto;


}
