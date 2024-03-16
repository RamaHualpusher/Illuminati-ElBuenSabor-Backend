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
    @Column(name = "subtotal")
    private Double subtotal;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_factura")
    private Factura factura;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

}
