package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.PedidoDto;
import com.illuminati.ebs.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController extends GenericController<PedidoDto, Long>{
    public PedidoController(PedidoService service) {
        super(service);
    }
}
