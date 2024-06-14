package com.illuminati.ebs.repository;

import com.illuminati.ebs.entity.Factura;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacturaRepository extends GenericRepository<Factura,Long>{
    Optional<Factura> findByPedidoId(Long pedidoId);
}
