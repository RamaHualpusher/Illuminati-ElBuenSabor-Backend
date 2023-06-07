package com.illuminati.ebs.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ProductoManufacturado_Ingrediente")
@AttributeOverride(name = "id", column = @Column(name = "id_producto_manufacturado_ingrediente"))
public class ProductoManufacturado_Ingrediente extends Base{
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "id_producto_manufacturado")
    private ProductoManufacturado productoManufacturado;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;

    @Column(name = "cantidad")
    private Integer cantidad;
}
