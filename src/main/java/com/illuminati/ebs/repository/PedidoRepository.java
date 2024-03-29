package com.illuminati.ebs.repository;

import com.illuminati.ebs.dto.PedidoDto;
import com.illuminati.ebs.entity.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends GenericRepository<Pedido, Long>{
    @Query("SELECT p FROM Pedido p WHERE p.usuario.id = :usuarioId")
    List<Pedido> findByUsuarioId(@Param("usuarioId") Long usuarioId);

    @Query("SELECT p FROM Pedido p JOIN FETCH p.detallesPedidos dp JOIN FETCH dp.producto WHERE p.id = :pedidoId")
    Optional<PedidoDto> findPedidoWithDetallesAndProductosById(@Param("pedidoId") Long pedidoId);
    @Query("SELECT p FROM Pedido p WHERE p.estadoPedido = :estadoPedido")
    List<Pedido> findByEstadoPedido(@Param("estadoPedido") String estadoPedido);
}
