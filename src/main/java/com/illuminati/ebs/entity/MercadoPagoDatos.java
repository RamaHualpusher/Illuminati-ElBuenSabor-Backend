package com.illuminati.ebs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "MercadoPagoDatos")
@Data
public class MercadoPagoDatos extends Base{

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "preference_id")
    private String preferenceId;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

}