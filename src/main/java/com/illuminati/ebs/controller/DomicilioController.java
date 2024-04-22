package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.DomicilioDto;
import com.illuminati.ebs.entity.Domicilio;
import com.illuminati.ebs.service.DomicilioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/domicilio")
public class DomicilioController extends GenericController<Domicilio, Long>{
    public DomicilioController(DomicilioService service) {
        super(service);
    }
}
