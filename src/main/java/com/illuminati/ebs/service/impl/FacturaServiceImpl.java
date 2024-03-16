package com.illuminati.ebs.service.impl;


import com.illuminati.ebs.entity.Factura;
import com.illuminati.ebs.repository.FacturaRepository;
import com.illuminati.ebs.service.FacturaService;

public class FacturaServiceImpl extends GenericServiceImpl<Factura,Long> implements FacturaService {
    public FacturaServiceImpl(FacturaRepository repository){
        super(repository);
    }
}
