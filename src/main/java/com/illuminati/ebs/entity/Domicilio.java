package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Domicilio")
@AttributeOverride(name = "id", column = @Column(name = "id_domicilio"))
@Data
public class Domicilio extends Base{

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "localidad")
    private String localidad;

    @OneToOne(mappedBy = "domicilio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Usuario usuario;
}
