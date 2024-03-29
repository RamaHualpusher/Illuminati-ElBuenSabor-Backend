package com.illuminati.ebs.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Producto_Ingrediente")
public class Producto_Ingrediente extends Base{
    @ManyToOne
    @JoinColumn(name = "id_producto")
    @JsonIgnore
    //Se podría ignorar ésta propiedad para hacer el GET desde producto y mostrar
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;

    @Column(name = "cantidad")
    private Integer cantidad;
}
