package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.*;
import com.illuminati.ebs.entity.DetallePedido;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = "*")
public class PedidoController extends GenericController<Pedido, Long>{
    //agregue "extends GenericController<Pedido, Long>{"
    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        //agregue super(pedidoService);
        super(pedidoService);
        this.pedidoService = pedidoService;
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Pedido> getPedidosByUsuarioId(@PathVariable Long usuarioId) {
        return pedidoService.findPedidosByUsuarioId(usuarioId);
    }

    @GetMapping("/pedido-completo/{id}")
    public PedidoDto getPedidoCompletoById(@PathVariable Long id) {
        Optional<PedidoDto> pedidoOptional = pedidoService.getPedidoCompletoById(id);
        if (pedidoOptional.isPresent()) {
            PedidoDto pedido = pedidoOptional.get();
            System.out.println(pedido);
            // Aquí debes convertir el Pedido a PedidoCompletoDTO
            PedidoDto pedidoDto = convertToPedidoCompletoDTO(pedido);
            return pedidoDto;
        } else {
            // Si el pedido no se encuentra, puedes devolver null o un mensaje de error
            return null;
        }
    }

    // Método para convertir Pedido a PedidoDto
    private PedidoDto convertToPedidoCompletoDTO(PedidoDto pedido) {
        // Crear un nuevo PedidoDto
        PedidoDto pedidoDto = new PedidoDto();

        // Llenar los campos simples del PedidoDto
        pedidoDto.setId(pedido.getId());
        pedidoDto.setNumeroPedido(pedido.getNumeroPedido());
        pedidoDto.setHoraEstimadaFin(pedido.getHoraEstimadaFin());
        pedidoDto.setTipoEnvio(pedido.getTipoEnvio());
        pedidoDto.setEsDelivery(pedido.isEsDelivery());
        pedidoDto.setEsEfectivo(pedido.isEsEfectivo());
        pedidoDto.setEstadoPedido(pedido.getEstadoPedido());
        pedidoDto.setFechaPedido(pedido.getFechaPedido());
        pedidoDto.setTotal(pedido.getTotal());

        // Llenar el usuario del PedidoDto
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(pedido.getUsuario().getId());
        usuarioDto.setNombre(pedido.getUsuario().getNombre());
        usuarioDto.setApellido(pedido.getUsuario().getApellido());
        usuarioDto.setEmail(pedido.getUsuario().getEmail());
        usuarioDto.setClave(pedido.getUsuario().getClave());
        usuarioDto.setTelefono(pedido.getUsuario().getTelefono());

        // Llenar el domicilio del usuario del PedidoDto
        DomicilioDto domicilioDto = new DomicilioDto();
        domicilioDto.setId(pedido.getUsuario().getDomicilio().getId());
        // Llenar otros campos del domicilio si es necesario

        // Asignar el domicilio al usuario del PedidoDto
        usuarioDto.setDomicilio(domicilioDto);

        // Asignar el usuario lleno al PedidoDto
        pedidoDto.setUsuario(usuarioDto);

        // Llenar los detalles de pedido del PedidoDto
        List<DetallePedidoDto> detallesPedidosDto = new ArrayList<>();
        for (DetallePedidoDto detallePedido : pedido.getDetallesPedidos()) {
            // Crear un nuevo DetallePedidoDto
            DetallePedidoDto detallePedidoDto = new DetallePedidoDto();

            // Llenar los campos simples del DetallePedidoDto
            detallePedidoDto.setId(detallePedido.getId());
            detallePedidoDto.setCantidad(detallePedido.getCantidad());
            detallePedidoDto.setSubtotal(detallePedido.getSubtotal());

            // Llenar el producto del DetallePedidoDto
            ProductoDto productoDto = new ProductoDto();
            productoDto.setId(detallePedido.getProducto().getId());
            productoDto.setNombre(detallePedido.getProducto().getNombre());
            productoDto.setTiempoEstimadoCocina(detallePedido.getProducto().getTiempoEstimadoCocina());
            // Llenar otros campos del producto si es necesario

            // Asignar el producto al detalle de pedido del PedidoDto
            detallePedidoDto.setProducto(productoDto);

            // Agregar el detalle de pedido lleno a la lista de detalles de pedido del PedidoDto
            detallesPedidosDto.add(detallePedidoDto);
        }

        // Asignar la lista de detalles de pedido al PedidoDto
        pedidoDto.setDetallesPedidos(detallesPedidosDto);

        // Asignar otros campos del PedidoDto si es necesario

        // Devolver el PedidoDto completo
        return pedidoDto;
    }

}