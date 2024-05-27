package com.illuminati.ebs.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Pedido")
@Data
public class Pedido extends  Base{

    @Column(name="hora_estimada_fin")
    private Date horaEstimadaFin;

    @Column(name = "es_delivery")
    private boolean esDelivery;

    @Column(name = "es_efectivo")
    private boolean esEfectivo;

    @Column(name = "estado_pedido")
    private String estadoPedido;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pedido")
    private Date fechaPedido;

    @Transient
    private Double total = 0.0;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<DetallePedido> detallesPedidos = new ArrayList<>();

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MercadoPagoDatos mercadoPagoDatos;
    public Double getTotal() {
        Double total = 0.0;
        for (DetallePedido detallePedido : detallesPedidos) {
            total += detallePedido.getSubtotal();
        }
        return total;
    }
}