package com.illuminati.ebs.dto;

import lombok.Data;

@Data
public class UserAuthDto {
    private Long idUserAuth;
    private String userId;
    private String email;
    private boolean blocked;
    private UsuarioDto usuario;
}
