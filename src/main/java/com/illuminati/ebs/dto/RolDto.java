package com.illuminati.ebs.dto;
import lombok.Data;

@Data
public class RolDto {
    private Long idRol;
    private String nombreRol;
    private UsuarioDto usuario;
}
