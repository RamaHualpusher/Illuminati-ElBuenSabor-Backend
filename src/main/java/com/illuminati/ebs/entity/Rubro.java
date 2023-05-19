package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Rubro")
@AttributeOverride(name = "id", column = @Column(name = "id_rubro"))
@Data
public class Rubro extends Base{
    @Column(name = "nombre")
    private String nombre;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rubro_padre")
    private Rubro rubroPadre;
    @OneToMany(mappedBy = "rubroPadre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rubro> rubrosHijos;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_articulo")
    private Articulo articulo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto_manufacturado")
    private ProductoManufacturado productoManufacturado;
}
