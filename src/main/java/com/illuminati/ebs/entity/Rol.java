package com.illuminati.ebs.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Rol")
@Data
public class Rol extends Base{

    @Column(name = "nombre_rol")
    private String nombreRol;
}
