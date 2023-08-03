package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.IngredienteDto;
import com.illuminati.ebs.entity.Ingrediente;
import com.illuminati.ebs.service.IngredienteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ingrediente")
public class IngredienteController extends GenericController<Ingrediente, Long>{
    public IngredienteController(IngredienteService service) {
        super(service);
    }
}
