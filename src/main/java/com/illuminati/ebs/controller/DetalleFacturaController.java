package com.illuminati.ebs.controller;

import com.illuminati.ebs.entity.DetalleFactura;
import com.illuminati.ebs.service.DetalleFacturaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detalle-factura")
@CrossOrigin(origins = "*")
public class DetalleFacturaController  extends GenericController<DetalleFactura,Long> {
    public DetalleFacturaController(DetalleFacturaService service){
        super(service);
    }
}
