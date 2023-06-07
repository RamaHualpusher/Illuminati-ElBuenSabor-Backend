package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "UnidadMedida")
@AttributeOverride(name = "id", column = @Column(name = "id_unidad_medida"))
@Data
public class UnidadMedida extends Base{
    @Column(name = "denominacion")
    private String denominacion;

    @OneToOne(mappedBy = "unidadMedida", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Articulo articulo;

    @OneToOne(mappedBy = "unidadMedida", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Ingrediente ingrediente;
}
