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

    @Column(name="telefono")
    private String telefono;

    //La clave no se guarda en la base de datos

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Domicilio> domicilios;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List <Pedido> pedidos;

    @OneToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @OneToOne
    @JoinColumn(name = "id_user_auth")
    private UserAuth userAuth;

}
