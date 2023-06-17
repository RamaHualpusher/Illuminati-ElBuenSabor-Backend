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
    @Column(name = "unidad_medida")
    private String unidadMedida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rubro")
    private Rubro rubro;

    @OneToMany(mappedBy = "ingrediente", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Producto_Ingrediente> productosIngredientes;
}
