package com.illuminati.ebs.repository;

import com.illuminati.ebs.entity.DetalleFactura;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleFacturaRespository extends GenericRepository<DetalleFactura,Long>{
    List<DetalleFactura> findByFacturaId(Long facturaId);
}