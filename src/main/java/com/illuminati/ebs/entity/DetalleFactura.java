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

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "nombre-producto")
    private String nombreProducto;
    @Column(name = "precio-producto")
    private Double precioProducto;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_factura")
    private Factura factura;

}
