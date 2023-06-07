package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "IngredienteCosto")
@AttributeOverride(name = "id", column = @Column(name = "id_ingrediente_costo"))
@Data
public class IngredienteCosto extends Base{
    @Column(name = "costo")
    private Double costo;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;
}
