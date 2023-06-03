package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Domicilio")
@AttributeOverride(name = "id", column = @Column(name = "id_domicilio"))
@Data
public class Domicilio extends Base{
    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "localidad")
    private String localidad;
}
