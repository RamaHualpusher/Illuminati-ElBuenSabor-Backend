package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.PedidoDto;
import com.illuminati.ebs.entity.DetallePedido;
import com.illuminati.ebs.entity.Ingrediente;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.repository.PedidoRepository;
import com.illuminati.ebs.service.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl extends GenericServiceImpl<Pedido, Long> implements PedidoService {

    private final PedidoRepository repository;
    private final UsuarioService usuarioService;
    private final DetallePedidoService detallePedidoService; // Inyecta el servicio de detalles de pedido

    private final IngredienteService ingredienteService;

    private final ProductoService productoService;

    public PedidoServiceImpl(PedidoRepository repository, UsuarioService usuarioService, DetallePedidoService detallePedidoService, IngredienteService ingredienteService, ProductoService productoService) {
        super(repository);
        this.repository = repository;
        this.usuarioService = usuarioService;
        this.detallePedidoService = detallePedidoService; // Inicializa el servicio de detalles de pedido
        this.ingredienteService = ingredienteService;
        this.productoService = productoService;
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
    public List<Pedido> findPedidosByEstado(String estadoPedido) {

        return repository.findByEstadoPedido(estadoPedido);
    }

    @Override
    @Transactional
    public Pedido save(Pedido entity) throws ServiceException {
        try {

            if (entity.getHoraEstimadaFin() == null) {
                throw new ServiceException("La hora estimada de fin no puede ser nula.");
            }

            // Cargar el usuario desde la base de datos utilizando el servicio de Usuario
            Usuario usuario = usuarioService.findById(entity.getUsuario().getId());

            // Asignar el usuario al pedido
            entity.setUsuario(usuario);

            // Guardar el pedido
            entity = genericRepository.save(entity);

            // Guardar los detalles del pedido
            for (DetallePedido detalle : entity.getDetallesPedidos()) {
                detalle.setActivo(true);
                detalle.setPedido(entity); // Establece la relación bidireccional
                detallePedidoService.save(detalle);
            }

            return entity;
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
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

    //    public void reducirIngrediente(Long idIngrediente, Integer cantidad){
//
//
//    }

}



