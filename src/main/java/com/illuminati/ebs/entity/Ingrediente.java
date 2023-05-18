package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Ingrediente")
@AttributeOverride(name = "id", column = @Column(name = "id_ingrediente"))
@Data
public class Ingrediente extends Base{
    @Column(name = "nombre")
    String nombre;
    @Column(name = "estado")
    Boolean estado;
    @Column(name = "stock_minimo")
    Integer stockMinimo;
    @Column(name = "stock_actual")
    Integer stockActual;
    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Rubro> rubros;
    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<IngredienteCosto> ingredientesCosto;
    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<IngredienteStockActual> ingredientesStockActual;

    @ManyToMany(
            fetch=FetchType.LAZY,
            targetEntity=ProductoManufacturado.class,
            cascade=CascadeType.ALL
    )
    @JoinTable(
            name="producto_manufacturado_ingrediente",
            joinColumns=@JoinColumn(name="id_ingrediente"),
            inverseJoinColumns=@JoinColumn(name="id_producto_manufacturado")
    )
    List<ProductoManufacturado> productosManufacturados;
}
