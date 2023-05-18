package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "EstadoPedido")
@AttributeOverride(name = "id", column = @Column(name = "id_estado_pedido"))
@Data
public class EstadoPedido extends Base{
    @OneToMany(mappedBy = "estadoPedido")
    private List<Pedido> pedidos;

    @Column
    private String descripcion;

    @Column
    private String tiempo;
}
