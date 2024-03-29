package com.illuminati.ebs.service;

import com.illuminati.ebs.entity.Factura;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.exception.ServiceException;

public interface FacturaService extends GenericService<Factura,Long>{
    public Factura saveFactura(Pedido pedido) throws ServiceException;
}
