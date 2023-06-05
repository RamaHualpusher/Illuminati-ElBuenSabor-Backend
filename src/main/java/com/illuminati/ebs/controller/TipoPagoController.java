package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.TipoPagoDto;
import com.illuminati.ebs.service.TipoPagoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipo-pagos")
public class TipoPagoController extends GenericController<TipoPagoDto, Long>{
    public TipoPagoController(TipoPagoService service) {
        super(service);
    }
}
