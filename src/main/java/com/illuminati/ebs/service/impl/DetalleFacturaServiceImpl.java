package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.entity.DetalleFactura;
import com.illuminati.ebs.repository.DetalleFacturaRespository;
import com.illuminati.ebs.service.DetalleFacturaService;

public class DetalleFacturaServiceImpl  extends GenericServiceImpl<DetalleFactura,Long> implements DetalleFacturaService {
    public DetalleFacturaServiceImpl(DetalleFacturaRespository respository){
        super(respository);
    }
}
