package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.UsuarioDto;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.mapper.UsuarioMapper;
import com.illuminati.ebs.repository.UsuarioRepository;
import com.illuminati.ebs.service.UsuarioService;
import com.illuminati.ebs.service.impl.GenericServiceImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<UsuarioDto, Usuario, Long> implements UsuarioService, UserDetailsService {

    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository, UsuarioMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = (Usuario) repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getClave(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRol().getNombreRol())));
    }
}