package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.UsuarioDto;
import com.illuminati.ebs.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper implements GenericMapper<UsuarioDto, Usuario> {

    private final DomicilioMapper domicilioMapper;
    private final PedidoMapper pedidoMapper;
    private final RolMapper rolMapper;
    private final UserAuthMapper userAuthMapper;

    public UsuarioMapper(DomicilioMapper domicilioMapper, PedidoMapper pedidoMapper, RolMapper rolMapper, UserAuthMapper userAuthMapper) {
        this.domicilioMapper = domicilioMapper;
        this.pedidoMapper = pedidoMapper;
        this.rolMapper = rolMapper;
        this.userAuthMapper = userAuthMapper;
    }

    @Override
    public Usuario toEntity(UsuarioDto dto) {
        Usuario entity = new Usuario();
        entity.setId(dto.getIdUsuario());
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setEmail(dto.getEmail());
        entity.setTelefono(dto.getTelefono());
        entity.setRol(rolMapper.toEntity(dto.getIdRol()));
        entity.setUserAuth(userAuthMapper.toEntity(dto.getIdUserAuth()));
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public UsuarioDto toDto(Usuario entity) {
        UsuarioDto dto = new UsuarioDto();
        dto.setIdUsuario(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setEmail(entity.getEmail());
        dto.setTelefono(entity.getTelefono());
        dto.setIdRol(entity.getRol().getId());
        dto.setIdUserAuth(entity.getUserAuth().getId());
        // Asigna los valores restantes...

        return dto;
    }
}