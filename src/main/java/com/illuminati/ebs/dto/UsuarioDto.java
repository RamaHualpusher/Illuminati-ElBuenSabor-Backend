package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioDto {
        private Long id;
        private String nombre;
        private String apellido;
        private String email;
        private String clave;
        private String telefono;
        private DomicilioDto domicilio;
        private List<PedidoDto> pedidos;
        private RolDto rol;
}