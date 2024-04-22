package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.RankingUsuarioPedido;
import com.illuminati.ebs.dto.UsuarioDto;
import com.illuminati.ebs.entity.Domicilio;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.entity.Rol;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.mapper.UsuarioMapper;
import com.illuminati.ebs.repository.DomicilioRepository;
import com.illuminati.ebs.repository.RolRepository;
import com.illuminati.ebs.repository.UsuarioRepository;
import com.illuminati.ebs.service.UsuarioService;
import com.illuminati.ebs.service.impl.GenericServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Long> implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final DomicilioRepository domicilioRepository;
    private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository, DomicilioRepository domicilioRepository) {
        super(usuarioRepository);
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.domicilioRepository = domicilioRepository;
    }
    @Override
    public List<RankingUsuarioPedido> findRankingUsuarioPedidos() throws ServiceException {
        try {
            List<Object[]> results = usuarioRepository.findRankingUsuarioPedidos();
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
            return usuarioRepository.findAllClientes();
        } catch (Exception e) {
            throw new ServiceException("Error al obtener la lista de clientes por rol: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> obtenerListaEmpleados() throws ServiceException {
        try {
            return usuarioRepository.findAllEmpleados();
        } catch (Exception e) {
            throw new ServiceException("Error al obtener la lista de usuarios que no son clientes: " + e.getMessage());
        }
    }
    @Override
    public Usuario buscarClientePorEmail(String email) throws ServiceException {
        try {
            Optional<Usuario> clienteOptional = usuarioRepository.findByEmailAndCliente(email);
            return clienteOptional.orElse(null); // Devuelve el usuario si se encuentra, de lo contrario null
        } catch (Exception e) {
            throw new ServiceException("Error al buscar usuario cliente por email: " + e.getMessage());
        }
    }
    @Override
    public Usuario crearClienteSiNoExiste(Usuario usuario) throws ServiceException {
        // Verificar si el usuario ya existe
        String email = usuario.getEmail();
        Usuario clienteExistente = buscarClientePorEmail(email);
        if (clienteExistente != null) {
            // Log para informar que el cliente ya existe
            log.info("El usuario con el correo electrónico {} ya existe.", email);
            // Emitir un error 404 (NOT FOUND) ya que el usuario ya existe
            throw new ServiceException("El usuario con el correo electrónico ya existe", HttpStatus.NOT_FOUND);
        } else {
            // Validar campos obligatorios
            if (usuario.getNombre() == null || usuario.getApellido() == null || usuario.getEmail() == null) {
                // Log para registrar el error de campos obligatorios faltantes
                log.error("El usuario proporcionado no tiene todos los campos obligatorios: {}", usuario);
                throw new ServiceException("El usuario proporcionado no tiene todos los campos obligatorios", HttpStatus.BAD_REQUEST);
            }

            // Validar formato de correo electrónico
            if (!isValidEmail(usuario.getEmail())) {
                // Log para registrar el error de formato de correo electrónico inválido
                log.error("El correo electrónico proporcionado no es válido: {}", usuario.getEmail());
                throw new ServiceException("El correo electrónico proporcionado no es válido", HttpStatus.BAD_REQUEST);
            }

            // Asignar rol de cliente si no tiene rol asignado
            Rol clienteRol = rolRepository.findByNombreRol("Cliente");
            if (clienteRol == null) {
                // Log para registrar el error de no encontrar el rol "Cliente"
                log.error("No se encontró el rol 'Cliente' en la base de datos");
                throw new ServiceException("No se encontró el rol 'Cliente' en la base de datos", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            usuario.setRol(clienteRol);

            //Setear estado activo
            usuario.setActivo(true);
            // Guardar el nuevo cliente
            try {
                Usuario nuevoCliente = usuarioRepository.save(usuario);
                // Log para registrar la creación exitosa del nuevo cliente
                log.info("Se creó exitosamente un nuevo cliente con el correo electrónico: {}", nuevoCliente.getEmail());
                return nuevoCliente;
            } catch (Exception e) {
                // Log para registrar el error al crear el cliente
                log.error("Error al crear el usuario cliente: {}", e.getMessage());
                throw new ServiceException("Error al crear el usuario cliente: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    // Método para validar el formato de correo electrónico usando una expresión regular
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return email != null && pattern.matcher(email).matches();
    }

    @Override
    public Domicilio obtenerDomicilioUsuarioPorId(Long usuarioId) throws ServiceException {
        try {
            // Usa el UsuarioRepository para obtener el usuario por su ID
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
            if (usuarioOptional.isPresent()) {
                Usuario usuario = usuarioOptional.get();
                // Retorna el domicilio del usuario si existe
                return usuario.getDomicilio();
            } else {
                // Lanza una excepción si el usuario no se encuentra
                throw new ServiceException("No se encontró el usuario con el ID proporcionado", HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            // Captura excepciones relacionadas con problemas de acceso a datos
            throw new ServiceException("Error al acceder a los datos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            // Captura todas las demás excepciones no esperadas
            throw new ServiceException("Error inesperado al obtener el domicilio del usuario: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void guardarDireccionUsuario(Long usuarioId, Domicilio domicilio) throws ServiceException {
        try {
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
            if (usuarioOptional.isPresent()) {
                Usuario usuario = usuarioOptional.get();
                usuario.setDomicilio(domicilio);
                usuarioRepository.save(usuario);
            } else {
                throw new ServiceException("No se encontró el usuario con el ID proporcionado", HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            throw new ServiceException("Error al acceder a los datos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            throw new ServiceException("Error inesperado al guardar la dirección del usuario: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional
    public void actualizarDireccionUsuario(Long usuarioId, Domicilio domicilio) throws ServiceException {
        try {
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
            if (usuarioOptional.isPresent()) {
                Usuario usuario = usuarioOptional.get();
                if(usuario.getDomicilio() != null) {
                    Long idDomicilio = usuario.getDomicilio().getId();
                    Optional<Domicilio> domicilioOptional = domicilioRepository.findById(idDomicilio);
                    if (domicilioOptional.isPresent()){
                        Domicilio nuevoDomicilio = domicilioOptional.get();
                        nuevoDomicilio.setCalle(domicilio.getCalle());
                        nuevoDomicilio.setLocalidad(domicilio.getLocalidad());
                        nuevoDomicilio.setNumero(domicilio.getNumero());
                        domicilioRepository.save(nuevoDomicilio);
                    }
                    }
            } else {
                throw new ServiceException("No se encontró el usuario con el ID proporcionado", HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            throw new ServiceException("Error al acceder a los datos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            throw new ServiceException("Error inesperado al actualizar la dirección del usuario: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
