package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "TipoPago")
@AttributeOverride(name = "id", column = @Column(name = "id_tipo_pago"))
@Data
public class TipoPago extends Base{
    @OneToMany(mappedBy = "tipoPago")
    private List<Pedido> pedidos;

    @Column
    private String descripcion;
}

//ACA FALTA LA RELACION DE MERCADOPAGO
