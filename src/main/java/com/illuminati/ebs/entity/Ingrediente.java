package com.illuminati.ebs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.ArrayList;

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

    @OneToOne
    @JoinColumn(name = "id_rubro")
    private Rubro rubro;

}
