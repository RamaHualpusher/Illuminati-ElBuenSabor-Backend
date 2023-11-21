package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.RankingUsuarioPedido;
import com.illuminati.ebs.dto.UsuarioDto;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.mapper.UsuarioMapper;
import com.illuminati.ebs.repository.UsuarioRepository;
import com.illuminati.ebs.service.UsuarioService;
import com.illuminati.ebs.service.impl.GenericServiceImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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
            return results.stream()
                    .filter(row -> row.length >= 17 && noNullValues(row)) // Filtra filas con al menos 17 valores y sin nulos
                    .map(row -> new RankingUsuarioPedido(
                            (Long) row[0],
                            (Boolean) row[1],
                            (String) row[2],
                            (String) row[3],
                            (String) row[4],
                            (String) row[5],
                            (String) row[6],
                            (Long) row[7],
                            (Boolean) row[8],
                            (String) row[9],
                            (Integer) row[10],
                            (String) row[11],
                            (Long) row[12],
                            (Boolean) row[13],
                            (String) row[14],
                            (Long) row[15],
                            (String) row[16]
                    ))
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            // Captura excepciones relacionadas con problemas de acceso a datos
            throw new ServiceException("Error al acceder a los datos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            // Captura todas las demás excepciones no esperadas
            throw new ServiceException("Error inesperado al obtener el ranking de usuarios por pedidos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para verificar la ausencia de valores nulos en una fila
    private boolean noNullValues(Object[] row) {
        return Arrays.stream(row).noneMatch(Objects::isNull);
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
