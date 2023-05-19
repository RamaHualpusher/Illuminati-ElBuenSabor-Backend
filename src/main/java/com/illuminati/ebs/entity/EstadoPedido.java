package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "EstadoPedido")
@AttributeOverride(name = "id", column = @Column(name = "id_estado_pedido"))
@Data
public class EstadoPedido extends Base{
    @OneToOne(mappedBy = "estadoPedido")
    private Pedido pedido;

    @Column
    private String descripcion;

    @Column
    private String tiempo;
}
