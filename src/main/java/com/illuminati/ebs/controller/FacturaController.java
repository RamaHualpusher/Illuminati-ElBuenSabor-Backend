package com.illuminati.ebs.controller;

import com.illuminati.ebs.entity.Factura;
import com.illuminati.ebs.service.FacturaService;

public class FacturaController extends GenericController<Factura,Long>{
    public FacturaController(FacturaService service){
        super(service);
    }
}
