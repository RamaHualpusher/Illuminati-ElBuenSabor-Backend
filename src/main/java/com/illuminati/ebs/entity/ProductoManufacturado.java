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
    private String nombre;
    @Column(name = "tiempo_estimado_cocina")
    private Integer tiempoEstimadoCocina;
    @Column(name = "denominacion")
    private String denominacion;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "stock_minimo")
    private Integer stockMinimo;
    @Column(name = "stock_actual")
    private Integer stockActual;
    @Column(name = "preparacion")
    private String preparacion;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}
            , mappedBy = "productosManufacturados"
            ,targetEntity = Ingrediente.class
    )
    private List<Ingrediente> ingredientes;

    @OneToMany(mappedBy = "productoManufacturado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductoManufacturadoVenta> productosManufacturadosVenta;

    @OneToMany(mappedBy = "productoManufacturado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductoManufacturadoCosto> productosManufacturadosCosto;

    @OneToMany(mappedBy = "productoManufacturado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rubro> rubros;

}
