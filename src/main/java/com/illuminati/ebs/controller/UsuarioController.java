package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.UsuarioDto;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends GenericController<Usuario, Long> {

    public UsuarioController(UsuarioService service) {
        super(service);
    }
}
