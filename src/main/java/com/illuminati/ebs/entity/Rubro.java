package com.illuminati.ebs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Rubro")
@Data
public class Rubro extends Base {
    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_rubro_padre")
    @JsonBackReference // Evita la serialización en esta dirección
    private Rubro rubroPadre;

    @OneToMany(mappedBy = "rubroPadre", fetch = FetchType.LAZY)
    @JsonIgnore // Ignorar la propiedad "rubrosHijos" en la serialización
    private List<Rubro> rubrosHijos;
}


