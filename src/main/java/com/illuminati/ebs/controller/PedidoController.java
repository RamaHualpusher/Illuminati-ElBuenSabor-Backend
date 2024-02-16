package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.PedidoDto;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}