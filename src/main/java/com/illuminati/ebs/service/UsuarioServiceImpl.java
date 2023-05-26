package com.illuminati.ebs.service;

import com.illuminati.ebs.dto.UsuarioDto;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.mapper.UsuarioMapper;
import com.illuminati.ebs.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<UsuarioDto, Usuario, Long> implements UsuarioService {

    public UsuarioServiceImpl(UsuarioRepository repository, UsuarioMapper mapper) {
        super(repository, mapper);
    }
}
