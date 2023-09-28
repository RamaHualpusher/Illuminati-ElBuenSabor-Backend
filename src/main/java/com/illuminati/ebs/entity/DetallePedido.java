package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DetallePedido")
@Data
public class DetallePedido extends Base{
    @Column(name = "cantidad")
    private Integer cantidad;
    @Transient
    private Double subtotal;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public Double getSubtotal() {
        return this.cantidad * this.producto.getPrecio();
    }
}
