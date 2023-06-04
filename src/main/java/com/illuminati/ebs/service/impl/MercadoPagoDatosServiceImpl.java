package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.MercadoPagoDatosDto;
import com.illuminati.ebs.entity.MercadoPagoDatos;
import com.illuminati.ebs.mapper.MercadoPagoDatosMapper;
import com.illuminati.ebs.repository.MercadoPagoDatosRepository;
import com.illuminati.ebs.service.MercadoPagoDatosService;
import org.springframework.stereotype.Service;

@Service
public class MercadoPagoDatosServiceImpl extends GenericServiceImpl<MercadoPagoDatosDto, MercadoPagoDatos, Long> implements MercadoPagoDatosService {

    public MercadoPagoDatosServiceImpl(MercadoPagoDatosRepository repository, MercadoPagoDatosMapper mapper) {
        super(repository, mapper);
    }

}
