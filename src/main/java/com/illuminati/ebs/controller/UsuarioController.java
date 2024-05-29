package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.RankingUsuarioPedido;
import com.illuminati.ebs.entity.Domicilio;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.exception.ErrorResponse;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends GenericController<Usuario, Long> {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        super(service);
        this.service = service;
    }

    @PostMapping("/empleados")
    public ResponseEntity<?> crearEmpleado(@RequestBody Usuario usuario) {
        try {
            // Verificar que no es un cliente
            if ("Cliente".equalsIgnoreCase(usuario.getRol().getNombreRol())) {
                throw new ServiceException("No se puede crear un empleado con rol de cliente", HttpStatus.BAD_REQUEST);
            }
            Usuario empleadoCreado = service.crearEmpleado(usuario);
            return ResponseEntity.ok(empleadoCreado);
        } catch (ServiceException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatus().value(), e.getMessage());
            return ResponseEntity.status(e.getStatus()).body(errorResponse);
        }
    }
    //no uso a ranking, lo manejo todo con pedido
    @GetMapping("/ranking")
    public ResponseEntity<?> getTopUserRanking() {
        try {
            List<RankingUsuarioPedido> topUserRanking = service.findRankingUsuarioPedidos();
            return ResponseEntity.ok(topUserRanking);
        } catch (ServiceException e) {
            // Manejo de excepciones
            ErrorResponse errorResponse = new ErrorResponse(e.getStatus().value(), e.getMessage());
            return ResponseEntity.status(e.getStatus()).body(errorResponse);
        }
    }

    @GetMapping("/clientes")
    public ResponseEntity<?> getClientes() {
        try {
            List<Usuario> clientes = service.obtenerListaClientes();
            return ResponseEntity.ok(clientes);
        } catch (ServiceException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatus().value(), e.getMessage());
            return ResponseEntity.status(e.getStatus()).body(errorResponse);
        }
    }

    @GetMapping("/empleados")
    public ResponseEntity<?> getEmpleados() {
        try {
            List<Usuario> empleados = service.obtenerListaEmpleados();
            return ResponseEntity.ok(empleados);
        } catch (ServiceException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatus().value(), e.getMessage());
            return ResponseEntity.status(e.getStatus()).body(errorResponse);
        }
    }

    @PostMapping("/clientes/email")
    public ResponseEntity<?> buscarClientePorEmail(@RequestBody Usuario usuario) {
        try {
            if (usuario != null && usuario.getEmail() != null && !usuario.getEmail().isEmpty()) {
                Usuario cliente = service.buscarClientePorEmail(usuario.getEmail());
                if (cliente != null) {
                    return ResponseEntity.ok(cliente);
                } else {
                    ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "El usuario cliente con el email proporcionado no existe.");
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
                }
            } else {
                ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "El usuario proporcionado o su dirección de correo electrónico son inválidos.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }
        } catch (ServiceException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatus().value(), e.getMessage());
            return ResponseEntity.status(e.getStatus()).body(errorResponse);
        }
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> crearCliente(@RequestBody Usuario usuario) {
        try {
            Usuario clienteCreado = service.crearClienteSiNoExiste(usuario);
            return ResponseEntity.ok(clienteCreado);
        } catch (ServiceException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatus().value(), e.getMessage());
            return ResponseEntity.status(e.getStatus()).body(errorResponse);
        }
    }

    @GetMapping("/{usuarioId}/domicilio")
    public ResponseEntity<?> obtenerDomicilioUsuario(@PathVariable Long usuarioId) {
        try {
            // Llama al método en UsuarioService para obtener el domicilio del usuario por su ID
            Domicilio domicilio = service.obtenerDomicilioUsuarioPorId(usuarioId);
            return ResponseEntity.ok(domicilio);
        } catch (ServiceException e) {
            // Manejo de excepciones
            ErrorResponse errorResponse = new ErrorResponse(e.getStatus().value(), e.getMessage());
            return ResponseEntity.status(e.getStatus()).body(errorResponse);
        }
    }
    @PostMapping("/{usuarioId}/domicilio")
    public ResponseEntity<?> guardarDireccionUsuario(@PathVariable Long usuarioId, @RequestBody Domicilio domicilio) {
        try {
            // Llama al método en UsuarioService para guardar la dirección del usuario
            service.guardarDireccionUsuario(usuarioId, domicilio);
            return ResponseEntity.ok().build();
        } catch (ServiceException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatus().value(), e.getMessage());
            return ResponseEntity.status(e.getStatus()).body(errorResponse);
        }
    }
    @PutMapping("/{usuarioId}/domicilio")
    public ResponseEntity<?> actualizarDireccionUsuario(@PathVariable Long usuarioId, @RequestBody Domicilio domicilio) {
        try {
            // Llama al método en UsuarioService para actualizar la dirección del usuario
            service.actualizarDireccionUsuario(usuarioId, domicilio);
            return ResponseEntity.ok().build();
        } catch (ServiceException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatus().value(), e.getMessage());
            return ResponseEntity.status(e.getStatus()).body(errorResponse);
        }
    }


}
