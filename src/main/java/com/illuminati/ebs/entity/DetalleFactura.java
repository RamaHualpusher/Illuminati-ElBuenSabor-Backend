package com.illuminati.ebs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DetalleFactura")
@Data
public class DetalleFactura extends Base{
    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "nombre-producto")
    private String nombreProducto;
  
    @Transient
    @Column(name = "subtotal")
    private Double subtotal;
  
    @Column(name = "precio_producto")
    private Double precioProducto;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_factura")
    private Factura factura;

    @Transient
    public Double getSubtotal() {
        if(this.precioProducto != null && this.cantidad != null) {
            return this.cantidad * this.precioProducto;
        }else {
            return 0.0;
        }
    }
}
