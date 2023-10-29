package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.PedidoDto;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.mapper.PedidoMapper;
import com.illuminati.ebs.repository.PedidoRepository;
import com.illuminati.ebs.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl extends GenericServiceImpl<Pedido, Long> implements PedidoService {

    private final PedidoRepository repository;
    public PedidoServiceImpl(PedidoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<Pedido> findPedidosByUsuarioId(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
}
