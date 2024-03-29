package com.illuminati.ebs.service;


import com.illuminati.ebs.dto.RankingUsuarioPedido;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.exception.ServiceException;

import java.util.List;

public interface UsuarioService extends GenericService<Usuario, Long> {
    public List<RankingUsuarioPedido> findRankingUsuarioPedidos() throws ServiceException;
    List<Usuario> obtenerListaClientes() throws ServiceException;

    List<Usuario> obtenerListaEmpleados() throws ServiceException;

    public Usuario buscarClientePorEmail(String email) throws ServiceException;
    public Usuario crearClienteSiNoExiste(Usuario usuario) throws ServiceException;

}
