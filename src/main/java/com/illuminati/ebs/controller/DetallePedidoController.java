package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.DetallePedidoDto;
import com.illuminati.ebs.entity.DetallePedido;
import com.illuminati.ebs.service.DetallePedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detalle-pedido")
public class DetallePedidoController extends GenericController<DetallePedido, Long>{
    public DetallePedidoController(DetallePedidoService service) {
        super(service);
    }
}
