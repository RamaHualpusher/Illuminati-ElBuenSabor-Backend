package com.illuminati.ebs.dto;
import lombok.Data;

@Data
public class RolDto {
    private Long idRol;
    private String nombreRol;
    private UsuarioDto usuario;
    private String auth0RoleId; // Auth0 Role ID
    private String description; // Auth0 Role Description
}