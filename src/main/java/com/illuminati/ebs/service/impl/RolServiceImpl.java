package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.RolDto;
import com.illuminati.ebs.entity.Rol;
import com.illuminati.ebs.mapper.RolMapper;
import com.illuminati.ebs.repository.RolRepository;
import com.illuminati.ebs.service.RolService;
import com.illuminati.ebs.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends GenericServiceImpl<Rol, Long> implements RolService {

    private final RolRepository repository;

    public RolServiceImpl(RolRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Rol findByNombreRol(String nombreRol) {
        return repository.findByNombreRol(nombreRol);
    }
}
