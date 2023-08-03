package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.DetallePedidoDto;
import com.illuminati.ebs.entity.DetallePedido;
import com.illuminati.ebs.mapper.DetallePedidoMapper;
import com.illuminati.ebs.repository.DetallePedidoRepository;
import com.illuminati.ebs.service.DetallePedidoService;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoServiceImpl extends GenericServiceImpl<DetallePedido, Long> implements DetallePedidoService {

        public DetallePedidoServiceImpl(DetallePedidoRepository repository) {
            super(repository);
        }
}
