package com.illuminati.ebs.repository;

import com.illuminati.ebs.dto.ProductoRanking;
import com.illuminati.ebs.entity.DetallePedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends GenericRepository<DetallePedido, Long>{
}
