package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "TipoPago")
@AttributeOverride(name = "id", column = @Column(name = "id_tipo_pago"))
@Data
public class TipoPago extends Base{
    @OneToMany(mappedBy = "tipoPago", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

    @OneToOne(mappedBy = "tipoPago", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MercadoPagoDatos mercadoPagoDatos;

    @Column(name = "descripcion")
    private String descripcion;
}
