package com.illuminati.ebs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Ingrediente")
@Data
public class Ingrediente extends Base{

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "stock_minimo")
    private Integer stockMinimo;
    @Column(name = "stock_actual")
    private Integer stockActual;
    @Column(name = "unidad_medida")
    private String unidadMedida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rubro")
    @JsonIgnore  // Evita la recursión infinita al serializar
    private Rubro rubro;

    @OneToMany(mappedBy = "ingrediente", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Producto_Ingrediente> productosIngredientes;
}
