package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DetallePedido")
@AttributeOverride(name = "id", column = @Column(name = "id_detalle_pedido"))
@Data
public class DetallePedido extends Base{
    @Column(name = "cantidad")
    private Integer cantidad;
    @Transient
    private Double subtotal;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public Double getSubtotal() {
        return this.cantidad * this.producto.getPrecio();
    }
}
