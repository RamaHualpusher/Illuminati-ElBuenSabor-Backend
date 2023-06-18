package com.illuminati.ebs.dto;
import lombok.Data;

@Data
public class RolDto {
    private Long id;
    private UsuarioDto usuario;
    private String nombreRol;
}