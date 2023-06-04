package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.TipoEntregaPedidoDto;
import com.illuminati.ebs.entity.TipoEntregaPedido;
import com.illuminati.ebs.mapper.TipoEntregaPedidoMapper;
import com.illuminati.ebs.repository.TipoEntregaPedidoRepository;
import com.illuminati.ebs.service.TipoEntregaPedidoService;
import org.springframework.stereotype.Service;

@Service
public class TipoEntregaPedidoServiceImpl extends GenericServiceImpl<TipoEntregaPedidoDto, TipoEntregaPedido, Long> implements TipoEntregaPedidoService {
    public TipoEntregaPedidoServiceImpl(TipoEntregaPedidoRepository repository, TipoEntregaPedidoMapper mapper) {
        super(repository, mapper);
    }
}
