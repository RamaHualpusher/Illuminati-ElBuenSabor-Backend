package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.DetallePedidoDto;
import com.illuminati.ebs.entity.DetallePedido;
import com.illuminati.ebs.entity.Producto;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.mapper.DetallePedidoMapper;
import com.illuminati.ebs.repository.DetallePedidoRepository;
import com.illuminati.ebs.service.DetallePedidoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl extends GenericServiceImpl<DetallePedido, Long> implements DetallePedidoService {

        private final DetallePedidoRepository repository;
        public DetallePedidoServiceImpl(DetallePedidoRepository repository) {

            super(repository);
            this.repository = repository;
        }

        @Override
        public List<DetallePedido> findDetallesPedidoByPedidoId(Long pedidoId) {
            return repository.findByPedidoId(pedidoId);
        }

}
