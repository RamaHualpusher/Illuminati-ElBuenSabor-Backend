package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.UnidadMedidaDto;
import com.illuminati.ebs.entity.UnidadMedida;
import com.illuminati.ebs.mapper.UnidadMedidaMapper;
import com.illuminati.ebs.repository.UnidadMedidaRepository;
import com.illuminati.ebs.service.UnidadMedidaService;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaServiceImpl extends GenericServiceImpl<UnidadMedidaDto, UnidadMedida, Long> implements UnidadMedidaService {
    public UnidadMedidaServiceImpl(UnidadMedidaRepository repository, UnidadMedidaMapper mapper) {
        super(repository, mapper);
    }
}
