package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.RankingUsuarioPedido;
import com.illuminati.ebs.dto.UsuarioDto;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.exception.ErrorResponse;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
