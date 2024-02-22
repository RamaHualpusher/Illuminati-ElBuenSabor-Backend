package com.illuminati.ebs.dto;

import com.illuminati.ebs.entity.Domicilio;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.entity.Rol;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RankingUsuarioPedido {
    private Long id;
    private boolean activo;
    private String nombre;
    private String apellido;
    private String email;
    private String clave;
    private String telefono;
    private Domicilio domicilio;
    private Rol rol;
    private List<Pedido> pedidos;

    public RankingUsuarioPedido() {
    }

    public RankingUsuarioPedido(Long id, boolean activo, String nombre, String apellido, String email, String clave, String telefono, Domicilio domicilio, Rol rol, List<Pedido> pedidos) {
        this.id = id;
        this.activo = activo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.clave = clave;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.rol = rol;
        this.pedidos = pedidos;
    }

}
