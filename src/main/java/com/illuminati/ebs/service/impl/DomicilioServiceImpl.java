package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.DomicilioDto;
import com.illuminati.ebs.entity.Domicilio;
import com.illuminati.ebs.mapper.DomicilioMapper;
import com.illuminati.ebs.repository.DomicilioRepository;
import com.illuminati.ebs.service.DomicilioService;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServiceImpl extends GenericServiceImpl<DomicilioDto, Domicilio, Long> implements DomicilioService {

    public DomicilioServiceImpl(DomicilioRepository repository, DomicilioMapper mapper) {
        super(repository, mapper);
    }

}
