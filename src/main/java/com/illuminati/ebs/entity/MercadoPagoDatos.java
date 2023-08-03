package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "MercadoPagoDatos")
@Data
public class MercadoPagoDatos extends Base{
    @Column(name = "identificador_pago")
    private Integer identificadorPago;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_aprobacion")
    private Date fechaAprobacion;

    @Column(name = "forma_pago")
    private String formaPago;

    @Column(name = "metodo_pago")
    private String metodoPago;

    @Column(name = "num_tarjeta")
    private String numTarjeta;

    @Column(name = "estado")
    private String estado;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
}
