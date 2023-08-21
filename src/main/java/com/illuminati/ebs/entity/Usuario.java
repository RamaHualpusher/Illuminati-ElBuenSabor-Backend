package com.illuminati.ebs.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Usuario")
@Data
public class Usuario extends Base{
    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="email")
    private String email;

    @Column(name="clave")
    private String clave;

    @Column(name="telefono")
    private String telefono;


    @OneToOne
    @JoinColumn(name = "id_domicilio")
    private Domicilio domicilio;

    @OneToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List <Pedido> pedidos;

}
