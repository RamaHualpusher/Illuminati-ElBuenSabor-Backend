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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rubro")
    private Rubro rubro;

    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<IngredienteCosto> ingredientesCosto;
    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<IngredienteStockActual> ingredientesStockActual;

    @OneToOne
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedida unidadMedida;

    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductoManufacturado_Ingrediente> productosManufacturadosIngredientes;
}
