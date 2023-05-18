package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "UnidadMedida")
@AttributeOverride(name = "id", column = @Column(name = "id_unidad_medida"))
@Data
public class UnidadMedida extends Base{
    @Column(name = "denominacion")
    String denominacion;

    @OneToMany(mappedBy = "unidadMedida", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Articulo> articulos;
}
