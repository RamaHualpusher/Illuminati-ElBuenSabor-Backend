package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Rol")
@Data
public class Rol extends Base{
    @OneToOne(mappedBy = "rol")
    private Usuario usuarios;

    @Column(name = "nombre_rol")
    private String nombreRol;
}
