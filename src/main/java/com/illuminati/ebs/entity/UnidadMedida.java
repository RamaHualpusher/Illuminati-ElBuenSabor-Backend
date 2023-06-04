package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "UnidadMedida")
@AttributeOverride(name = "id", column = @Column(name = "id_unidad_medida"))
@Data
public class UnidadMedida extends Base{
    @Column(name = "denominacion")
    private String denominacion;

    @OneToOne(mappedBy = "unidadMedida")
    private Articulo articulo;

    @OneToOne(mappedBy = "unidadMedida")
    private Ingrediente ingrediente;
}
