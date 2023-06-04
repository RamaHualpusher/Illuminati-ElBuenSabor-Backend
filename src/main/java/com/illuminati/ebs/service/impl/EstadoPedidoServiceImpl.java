package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.EstadoPedidoDto;
import com.illuminati.ebs.entity.EstadoPedido;
import com.illuminati.ebs.mapper.EstadoPedidoMapper;
import com.illuminati.ebs.repository.EstadoPedidoRepository;
import com.illuminati.ebs.service.EstadoPedidoService;
import org.springframework.stereotype.Service;

@Service
public class EstadoPedidoServiceImpl extends GenericServiceImpl<EstadoPedidoDto, EstadoPedido, Long> implements EstadoPedidoService {

    public EstadoPedidoServiceImpl(EstadoPedidoRepository repository, EstadoPedidoMapper mapper) {
        super(repository, mapper);
    }

}
