package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.EstadoPedidoDto;
import com.illuminati.ebs.service.EstadoPedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estado-pedidos")
public class EstadoPedidoController extends GenericController<EstadoPedidoDto, Long>{
    public EstadoPedidoController(EstadoPedidoService service) {
        super(service);
    }
}
