package com.illuminati.ebs.dto;
import lombok.Data;

@Data
public class UsuarioDto {
        private Long idUsuario;
        private String nombre;
        private String apellido;
        private String email;
        private String telefono;
        private RolDto rol;
        private UserAuthDto userAuth;
        // Agrega los campos adicionales según sea necesario
}