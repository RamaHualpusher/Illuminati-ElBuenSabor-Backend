package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.MercadoPagoDatosDto;
import com.illuminati.ebs.service.MercadoPagoDatosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mercado-pago-dato")
public class MercadoPagoDatosController extends GenericController<MercadoPagoDatosDto, Long>{
    public MercadoPagoDatosController(MercadoPagoDatosService service) {
        super(service);
    }
}
