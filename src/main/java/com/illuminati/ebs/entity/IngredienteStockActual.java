package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "IngredienteStockActual")
@AttributeOverride(name = "id", column = @Column(name = "id_ingrediente_stock_actual"))
@Data
public class IngredienteStockActual extends Base{
    @Column(name = "stock_actual")
    Integer stockActual;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    Date fecha;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ingrediente")
    Ingrediente ingrediente;
}
