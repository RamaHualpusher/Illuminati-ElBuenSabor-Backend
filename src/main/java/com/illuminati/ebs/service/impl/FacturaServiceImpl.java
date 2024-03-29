package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.entity.*;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.repository.FacturaRepository;
import com.illuminati.ebs.service.DetalleFacturaService;
import com.illuminati.ebs.service.FacturaService;
import com.illuminati.ebs.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class FacturaServiceImpl extends GenericServiceImpl<Factura, Long> implements FacturaService {

    private final FacturaRepository repository;
    private final DetalleFacturaService detalleFacturaService; // Inyecta el servicio de detalles de factura
    private final UsuarioService usuarioService; // Inyecta el servicio de usuario

    public FacturaServiceImpl(FacturaRepository repository, DetalleFacturaService detalleFacturaService, UsuarioService usuarioService) {
        super(repository);
        this.repository = repository;
        this.detalleFacturaService = detalleFacturaService;
        this.usuarioService = usuarioService; // Inicializa el servicio de usuario
    }

    @Transactional
    public Factura saveFactura(Pedido pedido) throws ServiceException {
        try {
            // Obtener el usuario del contexto de persistencia
            Usuario usuario = usuarioService.findById(pedido.getUsuario().getId());

            // Crear la factura
            Factura factura = new Factura();
            factura.setEsDelivery(pedido.isEsDelivery());
            factura.setEsEfectivo(pedido.isEsEfectivo());
            factura.setFechaFactura(new Date());
            factura.setTotal(pedido.getTotal());
            factura.setUsuario(usuario); // Asignar el usuario obtenido del contexto de persistencia
            factura.setPedido(pedido);

            // Guardar la factura
            factura = repository.save(factura);

            // Crear los detalles de factura
            for (DetallePedido detallePedido : pedido.getDetallesPedidos()) {
                DetalleFactura detalleFactura = new DetalleFactura();
                detalleFactura.setCantidad(detallePedido.getCantidad());
                detalleFactura.setSubtotal(detallePedido.getSubtotal());
                detalleFactura.setFactura(factura);
                detalleFactura.setProducto(detallePedido.getProducto());
                detalleFacturaService.save(detalleFactura);
            }

            return factura;
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Error al guardar la factura: " + e.getMessage());
        }
    }
}
