package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "Producto")
@AttributeOverride(name = "id", column = @Column(name = "id_producto"))
@Data
public class Producto extends Base{
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
    @Column(name = "precio")
    private Double precio;
    @Column(name = "es_bebida")
    private Boolean esBebida;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rubro")
    private Rubro rubro;

    @OneToMany(mappedBy = "producto", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DetallePedido> detallePedidos;

    @OneToMany(mappedBy = "producto", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Producto_Ingrediente> productosManufacturadosIngredientes;

}
