package com.illuminati.ebs.repository;

import com.illuminati.ebs.entity.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends GenericRepository<Producto, Long> {
}
