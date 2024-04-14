package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.entity.DetalleFactura;
import com.illuminati.ebs.repository.DetalleFacturaRespository;
import com.illuminati.ebs.service.DetalleFacturaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServiceImpl extends GenericServiceImpl<DetalleFactura, Long> implements DetalleFacturaService {
    private final DetalleFacturaRespository respository;

    public DetalleFacturaServiceImpl(DetalleFacturaRespository respository) {
        super(respository);
        this.respository = respository;
    }

    @Override
    public List<DetalleFactura> findByFacturaId(Long facturaId) {
        return respository.findByFacturaId(facturaId);
    }
}
