package com.illuminati.ebs.dto;

import com.illuminati.ebs.entity.Domicilio;
import com.illuminati.ebs.entity.Rol;
import lombok.Data;

import java.util.Date;

@Data
public class RankingUsuarioPedido {
    private Long id;
    private boolean activo;
    private String nombre;
    private String apellido;
    private String email;
    private String clave;
    private String telefono;
    private Long domicilioId;
    private Domicilio domicilio;
    private Rol rol;
    private Long cantidadPedidos;
    private String estadoPedido;
    private Date fechaPedido;

    public RankingUsuarioPedido(Long id, boolean activo, String nombre, String apellido, String email, String clave, String telefono,
                                Long domicilioId, boolean domicilioActivo, String domicilioCalle, Integer domicilioNumero, String domicilioLocalidad,
                                Long rolId, boolean rolActivo, String rolNombreRol, Long cantidadPedidos, String estadoPedido, Date fechaPedido) {
        this.id = id;
        this.activo = activo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.clave = clave;
        this.telefono = telefono;
        this.domicilioId = domicilioId;
        this.domicilio = new Domicilio(domicilioId, domicilioActivo, domicilioCalle, domicilioNumero, domicilioLocalidad);
        this.rol = new Rol(rolId, rolActivo, rolNombreRol);
        this.cantidadPedidos = cantidadPedidos;
        this.estadoPedido = estadoPedido;
        this.fechaPedido = fechaPedido;
    }
}
