package com.illuminati.ebs.dto;
import lombok.Data;

@Data
public class DomicilioDto {
    private Long id;
    private String calle;
    private Integer numero;
    private String localidad;
    private UsuarioDto usuario;
}
