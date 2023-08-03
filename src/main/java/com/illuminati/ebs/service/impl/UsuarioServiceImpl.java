package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.UsuarioDto;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.mapper.UsuarioMapper;
import com.illuminati.ebs.repository.UsuarioRepository;
import com.illuminati.ebs.service.UsuarioService;
import com.illuminati.ebs.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Long> implements UsuarioService {

    public UsuarioServiceImpl(UsuarioRepository repository) {
        super(repository);
    }
}
