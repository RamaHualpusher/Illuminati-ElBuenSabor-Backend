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
    @GetMapping("/estado/{estadoPedido}")
    public List<Pedido> getPedidosByEstado(@PathVariable String estadoPedido) {
        String estadoPedidoSinEspacios = estadoPedido.replace("_", " "); // Reemplaza los guiones bajos con espacios
        return pedidoService.findPedidosByEstado(estadoPedidoSinEspacios);
    }


}