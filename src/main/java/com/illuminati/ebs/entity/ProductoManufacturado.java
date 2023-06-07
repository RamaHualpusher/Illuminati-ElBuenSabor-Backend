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
    @Column(name = "preparacion", length = 1000)
    private String preparacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rubro")
    private Rubro rubro;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto_manufacturado")
    private List<DetallePedido> detallePedidos;

    @OneToMany(mappedBy = "productoManufacturado", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProductoManufacturado_Ingrediente> productosManufacturadosIngredientes;

    @OneToMany(mappedBy = "productoManufacturado", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProductoManufacturadoVenta> productosManufacturadosVenta;

    @OneToMany(mappedBy = "productoManufacturado", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProductoManufacturadoCosto> productosManufacturadosCosto;

}
