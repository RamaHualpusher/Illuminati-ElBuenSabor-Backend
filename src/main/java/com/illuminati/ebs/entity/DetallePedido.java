package com.illuminati.ebs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    @Transient
    private Integer maxCantidadProducto;



    @Transient
    public Double getSubtotal() {
        if(this.producto.getPrecio() != null && this.cantidad != null) {
            return this.cantidad * this.producto.getPrecio();
        }else {
            return 0.0;
        }
    }
}
