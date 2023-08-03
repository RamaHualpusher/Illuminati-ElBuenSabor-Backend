package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.PedidoDto;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController extends GenericController<Pedido, Long>{
    public PedidoController(PedidoService service) {
        super(service);
    }
}
