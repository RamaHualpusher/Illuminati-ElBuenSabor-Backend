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

    @OneToMany(mappedBy = "rubro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Articulo> articulos;

    @OneToMany(mappedBy = "rubro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingrediente> ingredientes;

    @OneToMany(mappedBy = "rubro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductoManufacturado> productoManufacturado;
}
