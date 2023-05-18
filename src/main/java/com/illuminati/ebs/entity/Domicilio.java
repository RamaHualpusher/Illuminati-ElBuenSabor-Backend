package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Domicilio")
@AttributeOverride(name = "id", column = @Column(name = "id_domicilio"))
@Data
public class Domicilio extends Base{
    @OneToMany(mappedBy = "domicilio")
    private List<Usuario> usuarios;

    @Column
    private String calle;

    @Column
    private Integer numero;

    @Column
    private String localidad;
}
