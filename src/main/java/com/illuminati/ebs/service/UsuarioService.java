package com.illuminati.ebs.service;


import com.illuminati.ebs.dto.RankingUsuarioPedido;
import com.illuminati.ebs.entity.Domicilio;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.exception.ServiceException;

import java.util.List;

public interface UsuarioService extends GenericService<Usuario, Long> {
    //modifique aca que tenia <RankingUsuarioPedido>, que utiliza una dto, cuando deberia utilizar los objetos nada mas de usuario, pedido, rol y dopmicilio
    public List<RankingUsuarioPedido> findRankingUsuarioPedidos() throws ServiceException;
    List<Usuario> obtenerListaClientes() throws ServiceException;

    List<Usuario> obtenerListaEmpleados() throws ServiceException;

    public Usuario buscarClientePorEmail(String email) throws ServiceException;

    public Usuario buscarEmpleadoPorEmail(String email) throws ServiceException;
    public Usuario crearClienteSiNoExiste(Usuario usuario) throws ServiceException;

    public Usuario crearEmpleado(Usuario usuario) throws ServiceException;

    public Domicilio obtenerDomicilioUsuarioPorId(Long usuarioId) throws ServiceException;

    public void guardarDireccionUsuario(Long usuarioId, Domicilio domicilio) throws ServiceException;
    public void actualizarDireccionUsuario(Long usuarioId, Domicilio domicilio) throws ServiceException;
}
