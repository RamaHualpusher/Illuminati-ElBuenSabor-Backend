package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.DetallePedidoDto;
import com.illuminati.ebs.entity.DetallePedido;
import com.illuminati.ebs.entity.Producto;
import com.illuminati.ebs.entity.Producto_Ingrediente;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.mapper.DetallePedidoMapper;
import com.illuminati.ebs.repository.DetallePedidoRepository;
import com.illuminati.ebs.service.DetallePedidoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        @Override
        public List<DetallePedido> findAll() throws ServiceException {
            List<DetallePedido> allEntities = super.findAll();
            allEntities.forEach(entity -> entity.setMaxCantidadProducto(calcularCantidadMaximaDeProductoPosible(entity)));
            return allEntities;
        }

        @Override
        public DetallePedido findById(Long id) throws ServiceException {
            DetallePedido detallePedido = super.findById(id);
            detallePedido.setMaxCantidadProducto(calcularCantidadMaximaDeProductoPosible(detallePedido));
            return detallePedido;
        }


        @Override
        public List<DetallePedido> findAllActive() throws ServiceException {
            List<DetallePedido> activeEntities = super.findAllActive();
            activeEntities.forEach(entity -> entity.setMaxCantidadProducto(calcularCantidadMaximaDeProductoPosible(entity)));
            return activeEntities;
        }

        private Integer calcularCantidadMaximaDeProductoPosible(DetallePedido detallePedido) {
            int cantidadSolicitada = detallePedido.getCantidad();
            List<Integer> stockDeIngredientes = new ArrayList<>();
            // Llenamos la lista de ingredientes
            for (Producto_Ingrediente productoIngrediente : detallePedido.getProducto().getProductosIngredientes()) {
                stockDeIngredientes.add(productoIngrediente.getIngrediente().getStockActual() / productoIngrediente.getCantidad());
            }
            return stockDeIngredientes.stream().min(Integer::compareTo).orElse(0);
        }
}
