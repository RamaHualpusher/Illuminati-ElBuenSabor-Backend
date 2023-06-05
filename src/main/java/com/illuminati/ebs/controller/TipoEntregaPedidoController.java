package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.TipoEntregaPedidoDto;
import com.illuminati.ebs.service.TipoEntregaPedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipo-entrega-pedidos")
public class TipoEntregaPedidoController extends GenericController<TipoEntregaPedidoDto, Long>{
    public TipoEntregaPedidoController(TipoEntregaPedidoService service) {
        super(service);
    }
}
