package com.illuminati.ebs.dto;
import lombok.Data;

@Data
public class UsuarioDto {
        private Long idUsuario;
        private String nombre;
        private String apellido;
        private String telefono;
        private RolDto rol;
        private DomicilioDto domicilio;
        private UserAuthDto userAuth;
}
