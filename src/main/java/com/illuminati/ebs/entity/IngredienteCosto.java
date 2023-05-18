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
    Double costo;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    Date fecha;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ingrediente")
    Ingrediente ingrediente;
}
