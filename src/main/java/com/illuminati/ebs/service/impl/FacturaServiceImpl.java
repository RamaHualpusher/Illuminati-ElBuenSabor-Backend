package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.entity.*;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.repository.FacturaRepository;
import com.illuminati.ebs.service.DetalleFacturaService;
import com.illuminati.ebs.service.FacturaService;
import com.illuminati.ebs.service.PedidoService;
import com.illuminati.ebs.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl extends GenericServiceImpl<Factura, Long> implements FacturaService {
    private final FacturaRepository repository;
    private final DetalleFacturaService detalleFacturaService;
    private final UsuarioService usuarioService;
    private final PedidoService pedidoService;

    public FacturaServiceImpl(FacturaRepository repository, DetalleFacturaService detalleFacturaService,
                              UsuarioService usuarioService, PedidoService pedidoService) {
        super(repository);
        this.repository = repository;
        this.detalleFacturaService = detalleFacturaService;
        this.usuarioService = usuarioService;
        this.pedidoService = pedidoService;
    }

    @Override
    @Transactional
    public Factura save(Factura entity) throws ServiceException{
        try{
            if (entity.getFechaFactura() == null) {
                entity.setFechaFactura(new Date());
            }
            if(entity.getActivo()==null || !entity.getActivo()){
                entity.setActivo(true);
            }
            // Validar si ya existe una factura con el mismo ID de pedido
            Optional<Factura> existingFactura = genericRepository.findById(entity.getPedido().getId());
            if (existingFactura.isPresent()) {
                throw new ServiceException("Ya existe una factura para el pedido con ID: " + entity.getPedido().getId());
            }

            // Obtener el pedido usando Optional y validar su presencia
            Optional<Pedido> optionalPedido = Optional.ofNullable(pedidoService.findById(entity.getPedido().getId()));
            Pedido pedido = optionalPedido.orElseThrow(() -> new ServiceException("Pedido no encontrado"));

            // Obtener el usuario usando Optional y validar su presencia
            Optional<Usuario> optionalUsuario = Optional.ofNullable(usuarioService.findById(entity.getUsuario().getId()));
            Usuario usuario = optionalUsuario.orElseThrow(() -> new ServiceException("Usuario no encontrado"));

            // Asignar el pedido y el usuario a la factura
            entity.setPedido(pedido);
            entity.setUsuario(usuario);

            // Guardar la factura
            entity = genericRepository.save(entity);

            // Guardar los detalles de la factura
            for (DetalleFactura detalle : entity.getDetalleFactura()) {
                detalle.setActivo(true);
                detalle.setFactura(entity); // Establece la relación bidireccional
                detalleFacturaService.save(detalle);
            }
            return entity;
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Error al guardar la factura: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Factura> findAll() throws ServiceException {
        try {
            List<Factura> facturas = super.findAll();
            for (Factura factura : facturas) {
                factura.setDetalleFactura(detalleFacturaService.findByFacturaId(factura.getId())); // Cargar detalles de factura
            }
            return facturas;
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Error al obtener las facturas: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public Factura findById(Long id) throws ServiceException {
        try {
            Factura factura = super.findById(id);
            if (factura != null) {
                factura.setDetalleFactura(detalleFacturaService.findByFacturaId(factura.getId())); // Cargar detalles de factura
            }
            return factura;
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Error al obtener la factura con ID " + id + ": " + e.getMessage());
        }
    }
}
