package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.RankingUsuarioPedido;
import com.illuminati.ebs.dto.UsuarioDto;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.exception.ErrorResponse;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.service.UsuarioService;
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
}
