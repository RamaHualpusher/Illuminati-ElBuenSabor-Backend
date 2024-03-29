package com.illuminati.ebs.repository;

import com.illuminati.ebs.dto.RankingUsuarioPedido;
import com.illuminati.ebs.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
                    "    p.id AS pedido_id, " +
                    "    p.estado_pedido AS estado_pedido, " +
                    "    p.fecha_pedido " +
                    "FROM " +
                    "    usuario u " +
                    "JOIN " +
                    "    domicilio d ON u.id_domicilio = d.id " +
                    "JOIN " +
                    "    rol r ON u.id_rol = r.id " +
                    "LEFT JOIN " +
                    "    pedido p ON p.id_usuario = u.id " +
                    "ORDER BY " +
                    "    u.id, " +
                    "    p.fecha_pedido DESC",
            nativeQuery = true)
    List<Object[]> findRankingUsuarioPedidos();

    @Query("SELECT u FROM Usuario u WHERE u.rol.id = 5")
    List<Usuario> findAllClientes();

    @Query("SELECT u FROM Usuario u WHERE u.rol.id IN (1, 2, 3, 4)")
    List<Usuario> findAllEmpleados();

}
