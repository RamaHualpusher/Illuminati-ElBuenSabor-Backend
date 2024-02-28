package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.PedidoDto;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.repository.PedidoRepository;
import com.illuminati.ebs.service.PedidoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    @Override
    public Optional<PedidoDto> getPedidoCompletoById(Long pedidoId) {
        return repository.findPedidoWithDetallesAndProductosById(pedidoId);
    }

    @Override
    @Transactional
    public Pedido save(Pedido entity) throws ServiceException {
        try {
            // Realizar validaciones y configuraciones adicionales aquí
            if (entity.getNumeroPedido() == null) {
                throw new ServiceException("El número de pedido no puede ser nulo.");
            }

            if (entity.getHoraEstimadaFin() == null) {
                throw new ServiceException("La hora estimada de fin no puede ser nula.");
            }

            // Realizar otras validaciones y configuraciones según sea necesario...

            // Guardar el pedido
            entity = genericRepository.save(entity);

            return entity;
        } catch (ServiceException e) {
            // Relanzar excepción de servicio con el mensaje adecuado
            throw e;
        } catch (Exception e) {
            // Capturar cualquier otra excepción y lanzar una ServiceException con un mensaje genérico
            throw new ServiceException("Error al guardar el pedido: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Pedido> findAll() throws ServiceException {
        try {
            List<Pedido> pedidos = genericRepository.findAll();
            if (pedidos.isEmpty()) {
                throw new EntityNotFoundException("No se encontraron pedidos.");
            }
            return pedidos;
        } catch (EntityNotFoundException e) {
            // Captura la excepción de entidad no encontrada y relanza una ServiceException con código de estado NOT_FOUND
            throw new ServiceException(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Captura cualquier otra excepción y lanza una ServiceException con código de estado INTERNAL_SERVER_ERROR
            throw new ServiceException("Error al buscar pedidos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional
    public Pedido findById(Long id) throws ServiceException {
        Optional<Pedido> entity = repository.findById(id);
        if(entity.isPresent()) {
            Pedido pedido = entity.get();
            //Aca validamos lo que queramos
        }
        try {
            return genericRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("No se encontró ninguna entidad con el ID: " + id));
        } catch (EntityNotFoundException e) {
            throw new ServiceException(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
