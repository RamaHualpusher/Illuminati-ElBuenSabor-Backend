package com.illuminati.ebs.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Domicilio")
@Data
public class Domicilio extends Base{

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "localidad")
    private String localidad;


    public Domicilio() {
    }
    public Domicilio(Long domicilioId, boolean domicilioActivo, String domicilioCalle, Integer domicilioNumero, String domicilioLocalidad) {
        this.setId(domicilioId);
        this.setActivo(domicilioActivo);
        this.calle = domicilioCalle;
        this.numero = domicilioNumero;
        this.localidad = domicilioLocalidad;
    }
}
