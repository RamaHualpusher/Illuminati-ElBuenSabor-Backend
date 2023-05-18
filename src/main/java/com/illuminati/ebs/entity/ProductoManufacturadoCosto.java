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
    Double precioCosto;
    @Column(name = "cantidad")
    Integer cantidad;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    Date fecha;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto_manufacturado")
    ProductoManufacturado productoManufacturado;

}
