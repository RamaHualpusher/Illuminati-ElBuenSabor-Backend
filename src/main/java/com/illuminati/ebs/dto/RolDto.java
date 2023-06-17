package com.illuminati.ebs.dto;
import lombok.Data;

@Data
public class RolDto {
    private Long idRol;
    private UsuarioDto usuario;
    private String nombreRol;
}