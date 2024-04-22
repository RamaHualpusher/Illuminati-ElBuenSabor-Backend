package com.illuminati.ebs.service;

import com.illuminati.ebs.entity.DetalleFactura;

import java.util.List;

public interface DetalleFacturaService extends GenericService<DetalleFactura,Long>{
    List<DetalleFactura> findByFacturaId(Long facturaId);
}
