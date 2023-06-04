package com.illuminati.ebs.dto;
import lombok.Data;

@Data
public class UsuarioDto {
        private Long idUsuario;
        private String nombre;
        private String apellido;
        private String email;
        private String telefono;
        private Long idRol;
        private Long idUserAuth;
        // Agrega los campos adicionales según sea necesario
}