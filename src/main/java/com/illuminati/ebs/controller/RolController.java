package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.RolDto;
import com.illuminati.ebs.entity.Rol;
import com.illuminati.ebs.service.RolService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rol")
public class RolController extends GenericController<Rol, Long> {

    public RolController(RolService service) {
        super(service);
    }
}
