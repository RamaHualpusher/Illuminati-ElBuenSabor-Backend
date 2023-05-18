package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Usuario")
@AttributeOverride(name = "id", column = @Column(name = "id_usuario"))
@Data
public class Usuario extends Base{
    @ManyToOne
    @JoinColumn(name = "id_domicilio", insertable = false, updatable = false)
    private Domicilio domicilio;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List <Pedido> pedidos;

    @OneToOne
    private Rol rol;

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

}
