package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.MercadoPagoDatosDto;
import com.illuminati.ebs.entity.MercadoPagoDatos;
import com.illuminati.ebs.service.MercadoPagoDatosService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mercado-pago-dato")
@CrossOrigin(origins = "*")
public class MercadoPagoDatosController extends GenericController<MercadoPagoDatos, Long>{
    public MercadoPagoDatosController(MercadoPagoDatosService service) {
        super(service);
    }
}