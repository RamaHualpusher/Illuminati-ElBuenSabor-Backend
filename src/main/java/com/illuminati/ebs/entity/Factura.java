package com.illuminati.ebs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Factura")
@Data
public class Factura extends Base{

    @Column(name = "es_efectivo")
    private boolean esEfectivo;

    @Column(name = "es_delivery")
    private boolean esDelivery;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_factura")
    private Date fechaFactura;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pedido")
    private Date fechaPedido;

    @Transient
    @Column(name = "total")
    private Double total = 0.0;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<DetalleFactura> detalleFactura = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_pedido", unique = true)
    private Pedido pedido;

    @Transient
    public Double getTotal() {
    Double total = 0.0;
    for (DetalleFactura detalleFactura : detalleFactura) {
        total += detalleFactura.getSubtotal();
    }
    return total;
}

}