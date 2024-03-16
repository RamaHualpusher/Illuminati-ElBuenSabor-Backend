package com.illuminati.ebs.controller;

import com.illuminati.ebs.entity.DetalleFactura;
import com.illuminati.ebs.service.DetalleFacturaService;

public class DetalleFacturaController  extends GenericController<DetalleFactura,Long> {
    public DetalleFacturaController(DetalleFacturaService service){
        super(service);
    }
}
