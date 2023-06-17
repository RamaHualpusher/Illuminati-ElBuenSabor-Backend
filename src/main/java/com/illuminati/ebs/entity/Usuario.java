package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Usuario")
@AttributeOverride(name = "id", column = @Column(name = "id_usuario"))
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


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_domicilio")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List <Pedido> pedidos;

    @OneToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

}
