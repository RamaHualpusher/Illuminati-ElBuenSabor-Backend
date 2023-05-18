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
    private String nombre;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "stock_minimo")
    private Integer stockMinimo;
    @Column(name = "stock_actual")
    private Integer stockActual;
    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rubro> rubros;
    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<IngredienteCosto> ingredientesCosto;
    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<IngredienteStockActual> ingredientesStockActual;

    @ManyToMany(
            fetch=FetchType.LAZY,
            targetEntity=ProductoManufacturado.class,
            cascade=CascadeType.ALL
    )
    @JoinTable(
            name="ProductoManufacturado_Ingrediente",
            joinColumns=@JoinColumn(name="id_ingrediente"),
            inverseJoinColumns=@JoinColumn(name="id_producto_manufacturado")
    )
    private List<ProductoManufacturado> productosManufacturados;
}
