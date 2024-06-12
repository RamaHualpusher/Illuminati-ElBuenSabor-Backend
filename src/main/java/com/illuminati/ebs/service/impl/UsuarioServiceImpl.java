package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.RankingUsuarioPedido;
import com.illuminati.ebs.entity.*;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.repository.DomicilioRepository;
import com.illuminati.ebs.repository.RolRepository;
import com.illuminati.ebs.repository.UsuarioRepository;
import com.illuminati.ebs.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Long> implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final DomicilioRepository domicilioRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository, DomicilioRepository domicilioRepository,  PasswordEncoder passwordEncoder) {
        super(usuarioRepository);
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.domicilioRepository = domicilioRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    @Transactional
    public Usuario crearEmpleado(Usuario usuario) throws ServiceException {
        // Verificar si el usuario ya existe
        String email = usuario.getEmail();
        Usuario empleadoExistente = buscarEmpleadoPorEmail(email);
        if (empleadoExistente != null) {
            log.info("El usuario con el correo electrónico {} ya existe.", email);
            throw new ServiceException("El usuario con el correo electrónico ya existe", HttpStatus.NOT_FOUND);
        } else {
            if (usuario.getNombre() == null || usuario.getApellido() == null || usuario.getEmail() == null || usuario.getRol() == null) {
                log.error("El usuario proporcionado no tiene todos los campos obligatorios: {}", usuario);
                throw new ServiceException("El usuario proporcionado no tiene todos los campos obligatorios", HttpStatus.BAD_REQUEST);
            }

            if (!isValidEmail(usuario.getEmail())) {
                log.error("El correo electrónico proporcionado no es válido: {}", usuario.getEmail());
                throw new ServiceException("El correo electrónico proporcionado no es válido", HttpStatus.BAD_REQUEST);
            }

            usuario.setActivo(true);
            usuario.setClave(passwordEncoder.encode(usuario.getClave()));
            if (!usuario.getRol().getNombreRol().equals("Admin") && !usuario.getRol().getNombreRol().equals("Cliente")) {
                usuario.setPrimerIngreso(true);
            } else {
                usuario.setPrimerIngreso(false);
            }

            // Guardar el domicilio
            Domicilio domicilio = usuario.getDomicilio();
            if (domicilio != null) {
                domicilio.setActivo(true);
                Domicilio nuevoDomicilio = domicilioRepository.save(domicilio);
                usuario.setDomicilio(nuevoDomicilio);
            }

            try {
                Usuario nuevoEmpleado = usuarioRepository.save(usuario);
                log.info("Se creó exitosamente un nuevo empleado con el correo electrónico: {}", nuevoEmpleado.getEmail());
                return nuevoEmpleado;
            } catch (Exception e) {
                log.error("Error al crear el usuario empleado: {}", e.getMessage());
                throw new ServiceException("Error al crear el usuario empleado: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    @Override
    @Transactional
    public Usuario actualizarEmpleado(Usuario usuario) throws ServiceException {
        // Verificar si el usuario existe
        Long id = usuario.getId();
        Usuario empleadoExistente = usuarioRepository.getById(id);
        if (empleadoExistente == null) {
            // Log para informar que el empleado no existe
            log.info("El usuario con el ID {} no existe.", id);
            // Emitir un error 404 (NOT FOUND) ya que el usuario no existe
            throw new ServiceException("El usuario con el ID no existe", HttpStatus.NOT_FOUND);
        } else {
            // Validar campos obligatorios
            if (usuario.getNombre() == null || usuario.getApellido() == null || usuario.getEmail() == null || usuario.getRol() == null) {
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

            // Actualizar los campos del empleado
            empleadoExistente.setNombre(usuario.getNombre());
            empleadoExistente.setApellido(usuario.getApellido());
            empleadoExistente.setRol(usuario.getRol());
            empleadoExistente.setActivo(usuario.getActivo());
            if(usuario.getClave()!=null){
                if(!usuario.getClave().equals("")){
                    // Encriptar la contraseña antes de guardar si ha cambiado
                    log.info("//////////CAMBIO DE CONTRASEÑA//////////");
                    log.info("Cambio" + !passwordEncoder.matches(usuario.getClave(),empleadoExistente.getClave()));
                    if (!passwordEncoder.matches(usuario.getClave(),empleadoExistente.getClave())) {
                        empleadoExistente.setClave(passwordEncoder.encode(usuario.getClave()));
                        empleadoExistente.setPrimerIngreso(false);
                    }
                }

            }


            // Guardar el empleado actualizado
            try {
                Usuario empleadoActualizado = usuarioRepository.save(empleadoExistente);
                // Log para registrar la actualización exitosa del empleado
                log.info("Se actualizó exitosamente el empleado con el correo electrónico: {}", empleadoActualizado.getEmail());
                return empleadoActualizado;
            } catch (Exception e) {
                // Log para registrar el error al actualizar el empleado
                log.error("Error al actualizar el usuario empleado: {}", e.getMessage());
                throw new ServiceException("Error al actualizar el usuario empleado: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @Override
    @Transactional
    public List<RankingUsuarioPedido> findRankingUsuarioPedidos() throws ServiceException {
        try {
            List<Object[]> results = usuarioRepository.findRankingUsuarioPedidos();
            Map<Long, RankingUsuarioPedido> usuarioMap = new HashMap<>();

            for (Object[] row : results) {
                Long usuarioId = (Long) row[0];
                if (!usuarioMap.containsKey(usuarioId)) {
                    Usuario usuario = new Usuario();
                    usuario.setActivo((Boolean) row[1]);
                    usuario.setNombre((String) row[2]);
                    usuario.setApellido((String) row[3]);
                    usuario.setEmail((String) row[4]);
                    usuario.setTelefono((String) row[5]);

                    Domicilio domicilio = new Domicilio();
                    domicilio.setId((Long) row[6]);
                    domicilio.setActivo((Boolean) row[7]);
                    domicilio.setCalle((String) row[8]);
                    domicilio.setNumero((Integer) row[9]);
                    domicilio.setLocalidad((String) row[10]);

                    Rol rol = new Rol();
                    rol.setId((Long) row[11]);
                    rol.setActivo((Boolean) row[12]);
                    rol.setNombreRol((String) row[13]);

                    RankingUsuarioPedido rankingUsuarioPedido = new RankingUsuarioPedido();
                    rankingUsuarioPedido.setId(usuarioId);
                    rankingUsuarioPedido.setActivo((Boolean) row[1]);
                    rankingUsuarioPedido.setNombre((String) row[2]);
                    rankingUsuarioPedido.setApellido((String) row[3]);
                    rankingUsuarioPedido.setEmail((String) row[4]);
                    rankingUsuarioPedido.setTelefono((String) row[5]);
                    rankingUsuarioPedido.setDomicilio(domicilio);
                    rankingUsuarioPedido.setRol(rol);
                    rankingUsuarioPedido.setPedidos(new ArrayList<>());

                    usuarioMap.put(usuarioId, rankingUsuarioPedido);
                }

                Pedido pedido = new Pedido();
                pedido.setId((Long) row[14]);
                pedido.setEstadoPedido((String) row[15]);
                pedido.setFechaPedido((Date) row[16]);

                // Verifica si el detalle del pedido no es nulo
                Long detallePedidoId = (Long) row[17];
                if (detallePedidoId != null) {
                    DetallePedido detallePedido = new DetallePedido();
                    detallePedido.setId(detallePedidoId);
                    detallePedido.setCantidad((Integer) row[18]);

                    // Crear un objeto Producto y establecer su ID y precio
                    Producto producto = new Producto();
                    producto.setId((Long) row[19]);  // Índice del ID del producto en la consulta SQL
                    producto.setPrecio((Double) row[20]);  // Índice del precio del producto en la consulta SQL

                    detallePedido.setProducto(producto);
                    pedido.getDetallesPedidos().add(detallePedido);
                }

                usuarioMap.get(usuarioId).getPedidos().add(pedido);
            }

            return new ArrayList<>(usuarioMap.values());
        } catch (DataAccessException e) {
            throw new ServiceException("Error al acceder a los datos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
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
            throw new ServiceException("Error al buscar cliente por email: " + e.getMessage());
        }
    }
    @Override
    public Usuario buscarEmpleadoPorEmail(String email) throws ServiceException {
        try {
            Optional<Usuario> empleadoOptional = usuarioRepository.findByEmailExcludingCliente(email);
            return empleadoOptional.orElse(null); // Devuelve el usuario si se encuentra, de lo contrario null
        } catch (Exception e) {
            throw new ServiceException("Error al buscar empleado por email: " + e.getMessage());
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
            usuario.setPrimerIngreso(false);
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
    @Transactional
    public void guardarDireccionUsuario(Long usuarioId, Domicilio domicilio) throws ServiceException {
        try {
            // Verifica si el usuario existe
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
            if (usuarioOptional.isPresent()) {
                Usuario usuario = usuarioOptional.get();

                // Verifica si el usuario ya tiene un domicilio
                if (usuario.getDomicilio() != null) {
                    throw new ServiceException("El usuario ya tiene asignada una dirección", HttpStatus.BAD_REQUEST);
                }

                // Verifica si la dirección es válida
                if (domicilio.getCalle() == null || domicilio.getNumero() == null || domicilio.getLocalidad() == null) {
                    throw new ServiceException("La dirección proporcionada no es válida", HttpStatus.BAD_REQUEST);
                }

                Domicilio nuevodomicilio = new Domicilio();
                // Setea el estado activo del domicilio
                nuevodomicilio.setActivo(true);
                nuevodomicilio.setCalle(domicilio.getCalle());
                nuevodomicilio.setNumero(domicilio.getNumero());
                nuevodomicilio.setLocalidad(domicilio.getLocalidad());
                domicilioRepository.save(nuevodomicilio);

                // Asigna el domicilio al usuario
                usuario.setDomicilio(nuevodomicilio);
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
