package com.illuminati.ebs.repository;

import com.illuminati.ebs.dto.RankingUsuarioPedido;
import com.illuminati.ebs.entity.Domicilio;
import com.illuminati.ebs.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario, Long> {
    @Query(value =
            "SELECT " +
                    "    u.id AS id, " +
                    "    u.activo AS activo, " +
                    "    u.nombre AS nombre, " +
                    "    u.apellido AS apellido, " +
                    "    u.email AS email, " +
                    "    u.clave AS clave, " +
                    "    u.telefono AS telefono, " +
                    "    d.id AS domicilio_id, " +
                    "    d.activo AS domicilio_activo, " +
                    "    d.activo AS domicilio_activo, " +
                    "    d.calle AS calle, " +
                    "    d.numero AS domicilio_numero, " +
                    "    d.localidad AS domicilio_localidad, " +
                    "    r.id AS rol_id, " +
                    "    r.activo AS rol_activo, " +
                    "    r.nombre_rol AS rol_nombre_rol, " +
                    "    p.id AS id_pedido, " +
                    "    p.estado_pedido AS estado_pedido, " +
                    "    p.fecha_pedido AS fecha_pedido" +
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

    @Query("SELECT u FROM Usuario u WHERE u.rol.nombreRol = 'Cliente'")
    List<Usuario> findAllClientes();

    @Query("SELECT u FROM Usuario u WHERE u.rol.nombreRol != 'Cliente'")
    List<Usuario> findAllEmpleados();

    @Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.rol.nombreRol = 'Cliente'")
    Optional<Usuario> findByEmailAndCliente(@Param("email") String email);

    @Modifying
    @Query("UPDATE Usuario u SET u.domicilio = :domicilio WHERE u.id = :usuarioId")
    void actualizarDireccionUsuario(@Param("usuarioId") Long usuarioId, @Param("domicilio") Domicilio domicilio);

}
