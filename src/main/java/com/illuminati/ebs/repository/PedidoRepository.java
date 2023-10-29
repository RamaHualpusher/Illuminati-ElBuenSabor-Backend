package com.illuminati.ebs.repository;

import com.illuminati.ebs.entity.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends GenericRepository<Pedido, Long>{
    @Query("SELECT p FROM Pedido p WHERE p.usuario.id = :usuarioId")
    List<Pedido> findByUsuarioId(@Param("usuarioId") Long usuarioId);
}
