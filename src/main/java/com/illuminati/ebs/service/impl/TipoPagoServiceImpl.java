package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.TipoPagoDto;
import com.illuminati.ebs.entity.TipoPago;
import com.illuminati.ebs.mapper.TipoPagoMapper;
import com.illuminati.ebs.repository.TipoPagoRepository;
import com.illuminati.ebs.service.TipoPagoService;
import org.springframework.stereotype.Service;

@Service
public class TipoPagoServiceImpl extends GenericServiceImpl<TipoPagoDto, TipoPago,Long> implements TipoPagoService {

        public TipoPagoServiceImpl(TipoPagoRepository repository, TipoPagoMapper mapper) {
            super(repository, mapper);
        }
}
