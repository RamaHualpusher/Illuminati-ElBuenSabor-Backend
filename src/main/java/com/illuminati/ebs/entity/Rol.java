package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Rol")
@AttributeOverride(name = "id", column = @Column(name = "id_rol"))
@Data
public class Rol extends Base{
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;

    @Column
    private String nombre_rol;
}
