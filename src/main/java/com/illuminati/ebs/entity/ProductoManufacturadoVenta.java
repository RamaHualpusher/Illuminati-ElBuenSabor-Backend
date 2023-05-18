package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "ProductoManufacturadoVenta")
@AttributeOverride(name = "id", column = @Column(name = "id_producto_manufacturado_venta"))
@Data
public class ProductoManufacturadoVenta extends Base{
    @Column(name = "precio_venta")
    private Double precioVenta;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto_manufacturado")
    private ProductoManufacturado productoManufacturado;
}
