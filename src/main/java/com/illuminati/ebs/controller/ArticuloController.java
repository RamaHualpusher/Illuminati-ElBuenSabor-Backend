package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.ArticuloDto;
import com.illuminati.ebs.service.ArticuloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController extends GenericController<ArticuloDto, Long>{
    public ArticuloController(ArticuloService service) {
        super(service);
    }
}
