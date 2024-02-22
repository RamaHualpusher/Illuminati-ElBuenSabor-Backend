package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.RankingUsuarioPedido;
import com.illuminati.ebs.dto.UsuarioDto;
import com.illuminati.ebs.entity.Domicilio;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.entity.Rol;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.mapper.UsuarioMapper;
import com.illuminati.ebs.repository.UsuarioRepository;
import com.illuminati.ebs.service.UsuarioService;
import com.illuminati.ebs.service.impl.GenericServiceImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Long> implements UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        super(repository);
        this.repository = repository;
    }
    @Override
    public List<RankingUsuarioPedido> findRankingUsuarioPedidos() throws ServiceException {
        try {
            List<Object[]> results = repository.findRankingUsuarioPedidos();
            Map<Long, RankingUsuarioPedido> usuarioMap = new HashMap<>();
            for (Object[] row : results) {
                Long usuarioId = (Long) row[0];
                if (!usuarioMap.containsKey(usuarioId)) {
                    Usuario usuario = new Usuario();
                    usuario.setId(usuarioId);
                    usuario.setActivo((Boolean) row[1]);
                    usuario.setNombre((String) row[2]);
                    usuario.setApellido((String) row[3]);
                    usuario.setEmail((String) row[4]);
                    usuario.setClave((String) row[5]);
                    usuario.setTelefono((String) row[6]);

                    Domicilio domicilio = new Domicilio();
                    domicilio.setId((Long) row[7]);
                    domicilio.setActivo((Boolean) row[8]);
                    domicilio.setCalle((String) row[9]);
                    domicilio.setNumero((Integer) row[10]);
                    domicilio.setLocalidad((String) row[11]);
                    // Otros campos de domicilio...

                    Rol rol = new Rol();
                    rol.setId((Long) row[12]);
                    rol.setActivo((Boolean) row[13]);
                    rol.setNombreRol((String) row[14]);
                    // Otros campos de rol...

                    RankingUsuarioPedido rankingUsuarioPedido = new RankingUsuarioPedido();
                    rankingUsuarioPedido.setId(usuarioId);
                    rankingUsuarioPedido.setActivo((Boolean) row[1]);
                    rankingUsuarioPedido.setNombre((String) row[2]);
                    rankingUsuarioPedido.setApellido((String) row[3]);
                    rankingUsuarioPedido.setEmail((String) row[4]);
                    rankingUsuarioPedido.setClave((String) row[5]);
                    rankingUsuarioPedido.setTelefono((String) row[6]);
                    rankingUsuarioPedido.setDomicilio(domicilio);
                    rankingUsuarioPedido.setRol(rol);
                    rankingUsuarioPedido.setPedidos(new ArrayList<>());

                    usuarioMap.put(usuarioId, rankingUsuarioPedido);
                }

                Pedido pedido = new Pedido();
                pedido.setId((Long) row[15]);
                pedido.setEstadoPedido((String) row[16]);
                pedido.setFechaPedido((Date) row[17]);
                // Otros campos de pedido...

                usuarioMap.get(usuarioId).getPedidos().add(pedido);
            }

            return new ArrayList<>(usuarioMap.values());
        } catch (DataAccessException e) {
            // Captura excepciones relacionadas con problemas de acceso a datos
            throw new ServiceException("Error al acceder a los datos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            // Captura todas las demás excepciones no esperadas
            throw new ServiceException("Error inesperado al obtener el ranking de usuarios por pedidos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Usuario> obtenerListaClientes() throws ServiceException {
        try {
            return repository.findAllClientes();
        } catch (Exception e) {
            throw new ServiceException("Error al obtener la lista de clientes por rol: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> obtenerListaEmpleados() throws ServiceException {
        try {
            return repository.findAllEmpleados();
        } catch (Exception e) {
            throw new ServiceException("Error al obtener la lista de usuarios que no son clientes: " + e.getMessage());
        }
    }

}
