package com.illuminati.ebs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Rubro")
@Data
public class Rubro extends Base{
    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_rubro_padre")
    @JsonIgnoreProperties("rubrosHijos") // Ignorar la propiedad "rubrosHijos" en la entidad Rubro para evitar el ciclo infinito
    private Rubro rubroPadre;

    @OneToMany(mappedBy = "rubroPadre", fetch = FetchType.LAZY)
    private List<Rubro> rubrosHijos;

    @OneToMany(mappedBy = "rubro", fetch = FetchType.LAZY)
    private List<Ingrediente> ingredientes;

    @OneToMany(mappedBy = "rubro", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonIgnoreProperties("rubro") // Ignorar la propiedad "rubro" en la entidad Producto para evitar el ciclo infinito
    private List<Producto> producto;
}
