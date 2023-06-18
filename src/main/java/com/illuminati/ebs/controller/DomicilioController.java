package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.DomicilioDto;
import com.illuminati.ebs.service.DomicilioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/domicilio")
public class DomicilioController extends GenericController<DomicilioDto, Long>{
    public DomicilioController(DomicilioService service) {
        super(service);
    }
}
