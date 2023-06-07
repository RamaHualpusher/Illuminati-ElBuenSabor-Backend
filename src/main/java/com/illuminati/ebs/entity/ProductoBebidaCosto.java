package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "ProductoBebidaCosto")
@AttributeOverride(name = "id", column = @Column(name = "id_producto_bebida_costo"))
@Data
public class ProductoBebidaCosto  extends Base {
    @Column(name = "costo")
    private Double costo;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_articulo", nullable = false)
    private Articulo articulo;

}
