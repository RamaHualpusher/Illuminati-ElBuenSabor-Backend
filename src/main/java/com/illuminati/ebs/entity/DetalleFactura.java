package com.illuminati.ebs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DetalleFactura")
@Data
public class DetalleFactura extends Base{
    @Column(name = "cantidad")
    private Integer cantidad;
    @Transient
    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Column(name = "precio_producto")
    private Double precioProducto;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_factura")
    private Factura factura;

    public Double getSubtotal() {
        if(this.precioProducto != null && this.cantidad != null) {
            return this.cantidad * this.precioProducto;
        }else {
            return 0.0;
        }
    }

}
