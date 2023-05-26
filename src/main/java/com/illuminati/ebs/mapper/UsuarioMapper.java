package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.UsuarioDto;
import com.illuminati.ebs.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper implements GenericMapper<UsuarioDto, Usuario> {

    @Override
    public Usuario toEntity(UsuarioDto dto) {
        Usuario entity = new Usuario();
        // Set entity fields based on dto
        return entity;
    }

    @Override
    public UsuarioDto toDto(Usuario entity) {
        UsuarioDto dto = new UsuarioDto();
        // Set dto fields based on entity
        return dto;
    }
}
