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

    @OneToMany(mappedBy = "usuario")
    private List <Pedido> pedidos;

    @ManyToOne
    @JoinColumn(name = "id_rol", insertable = false, updatable = false)
    private Rol rol;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String email;

    @Column
    private String clave;

    @Column
    private String telefono;

}
