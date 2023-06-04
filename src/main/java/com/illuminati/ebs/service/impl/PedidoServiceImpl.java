package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.PedidoDto;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.mapper.PedidoMapper;
import com.illuminati.ebs.repository.PedidoRepository;
import com.illuminati.ebs.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl extends GenericServiceImpl<PedidoDto, Pedido, Long> implements PedidoService {

    public PedidoServiceImpl(PedidoRepository repository, PedidoMapper mapper) {
        super(repository, mapper);
    }

}
