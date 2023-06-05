package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.IngredienteCostoDto;
import com.illuminati.ebs.service.IngredienteCostoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ingrediente-costos")
public class IngredienteCostoController extends GenericController<IngredienteCostoDto, Long>{
    public IngredienteCostoController(IngredienteCostoService service) {
        super(service);
    }
}
