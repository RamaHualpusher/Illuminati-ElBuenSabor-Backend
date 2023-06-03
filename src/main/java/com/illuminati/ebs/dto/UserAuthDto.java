package com.illuminati.ebs.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserAuthDto {
    private Long idUserAuth;
    private String userId;
    private String email;
    private boolean blocked;
    private UsuarioDto usuario;
    private String auth0UserId; // Auth0 User ID
    private String auth0Email; // Auth0 User Email
    private String password; // Auth0 User Password
    private String connection; // Auth0 Connection Name
    private boolean emailVerified; // Auth0 Email Verified Status
    private List<RolDto> roles; // Auth0 User Roles
}