package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.UnidadMedidaDto;
import com.illuminati.ebs.service.UnidadMedidaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/unidades-medida")
public class UnidadMedidaController extends GenericController<UnidadMedidaDto, Long>{
    public UnidadMedidaController(UnidadMedidaService service) {
        super(service);
    }
}
