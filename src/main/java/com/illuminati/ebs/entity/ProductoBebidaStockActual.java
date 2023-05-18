package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "ProductoBebidaStockActual")
@AttributeOverride(name = "id", column = @Column(name = "id_producto_bebida_stock_actual"))
@Data
public class ProductoBebidaStockActual extends Base {
    @Column(name = "stock_actual")
    private Integer stockActual;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto_bebida")
    private ProductoBebida productoBebida;
}
