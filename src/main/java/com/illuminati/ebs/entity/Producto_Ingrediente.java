package com.illuminati.ebs.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Producto_Ingrediente")
public class Producto_Ingrediente extends Base{
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;

    @Column(name = "cantidad")
    private Integer cantidad;
}
