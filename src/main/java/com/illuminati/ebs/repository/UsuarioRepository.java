package com.illuminati.ebs.repository;

import com.illuminati.ebs.dto.RankingUsuarioPedido;
import com.illuminati.ebs.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario, Long> {
    @Query(value =
            "SELECT " +
                    "    u.id, " +
                    "    u.activo, " +
                    "    u.nombre, " +
                    "    u.apellido, " +
                    "    u.email, " +
                    "    u.clave, " +
                    "    u.telefono, " +
                    "    d.id AS domicilio_id, " +
                    "    d.activo AS domicilio_activo, " +
                    "    d.calle, " +
                    "    d.numero AS domicilio_numero, " +
                    "    d.localidad AS domicilio_localidad, " +
                    "    r.id AS rol_id, " +
                    "    r.activo AS rol_activo, " +
                    "    r.nombre_rol AS rol_nombre_rol, " +
                    "    cantidad_pedidos, " +
                    "    estado_pedido " +
                    "FROM " +
                    "    ( " +
                    "        SELECT " +
                    "            p.id_usuario, " +
                    "            COUNT(p.id) AS cantidad_pedidos, " +
                    "            MAX(p.estado_pedido) AS estado_pedido " +
                    "        FROM pedido p " +
                    "        GROUP BY p.id_usuario " +
                    "    ) AS subquery " +
                    "JOIN usuario u ON u.id = subquery.id_usuario " +
                    "LEFT JOIN domicilio d ON u.id_domicilio = d.id " +
                    "LEFT JOIN rol r ON u.id_rol = r.id " +
                    "ORDER BY cantidad_pedidos DESC",
            nativeQuery = true)
    List<Object[]> findRankingUsuarioPedidos();

}
