package com.illuminati.ebs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "Producto")
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
    @JsonIgnoreProperties("producto") // Ignorar la propiedad "producto" en la entidad Rubro para evitar el ciclo infinito
    private Rubro rubro;

    @OneToMany(mappedBy = "producto", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore // Ignorar la propiedad "detallePedidos" en la entidad DetallePedido para evitar el ciclo infinito
    private List<DetallePedido> detallePedidos;

    @OneToMany(mappedBy = "producto", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore // Ignorar la propiedad "productosManufacturadosIngredientes" en la entidad Producto_Ingrediente para evitar el ciclo infinito
    private List<Producto_Ingrediente> productosManufacturadosIngredientes;

}
