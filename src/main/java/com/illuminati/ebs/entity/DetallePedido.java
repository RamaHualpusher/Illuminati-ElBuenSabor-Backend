package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DetallePedido")
@AttributeOverride(name = "id", column = @Column(name = "id_detalle_pedido"))
@Data
public class DetallePedido extends Base{
    @Column(name = "cantidad")
    Integer cantidad;
    @Column(name = "subtotal")
    Double subtotal;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_articulo")
    Articulo articulo;
}
