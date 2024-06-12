package com.illuminati.ebs.controller;

import com.illuminati.ebs.entity.MercadoPagoDatos;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.service.MercadoPagoDatosService;
import com.illuminati.ebs.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = "*")
public class PedidoController extends GenericController<Pedido, Long>{
    private final PedidoService pedidoService;
    private final MercadoPagoDatosService mercadoPagoDatosService;
    @Autowired
    public PedidoController(PedidoService pedidoService, MercadoPagoDatosService mercadoPagoDatosService) {
        super(pedidoService);
        this.pedidoService = pedidoService;
        this.mercadoPagoDatosService = mercadoPagoDatosService;
    }


    @GetMapping("/usuario/{usuarioId}")
    public List<Pedido> getPedidosByUsuarioId(@PathVariable Long usuarioId) {
        return pedidoService.findPedidosByUsuarioId(usuarioId);
    }
    @GetMapping("/estado/{estadoPedido}")
    public List<Pedido> getPedidosByEstado(@PathVariable String estadoPedido) {
        String estadoPedidoSinEspacios = estadoPedido.replace("_", " "); // Reemplaza los guiones bajos con espacios
        return pedidoService.findPedidosByEstado(estadoPedidoSinEspacios);
    }
    @PostMapping("/cancelar")
    public ResponseEntity<String> cancelarPedido(@RequestBody Pedido pedido) {
        try {
            pedidoService.cancelarPedido(pedido);
            return new ResponseEntity<>("Pedido cancelado exitosamente.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al cancelar el pedido: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


