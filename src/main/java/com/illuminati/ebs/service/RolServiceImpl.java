package com.illuminati.ebs.service;

import com.illuminati.ebs.dto.RolDto;
import com.illuminati.ebs.entity.Rol;
import com.illuminati.ebs.mapper.RolMapper;
import com.illuminati.ebs.repository.RolRepository;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends GenericServiceImpl<RolDto, Rol, Long> implements RolService {

    public RolServiceImpl(RolRepository repository, RolMapper mapper) {
        super(repository, mapper);
    }
}
