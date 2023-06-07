package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "ProductoManufacturadoCosto")
@AttributeOverride(name = "id", column = @Column(name = "id_producto_manufacturado_costo"))
@Data
public class ProductoManufacturadoCosto extends Base{
    @Column(name = "precio_costo")
    private Double precioCosto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_producto_manufacturado")
    private ProductoManufacturado productoManufacturado;

}
