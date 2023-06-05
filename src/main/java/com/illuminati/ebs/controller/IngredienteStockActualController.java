package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.IngredienteStockActualDto;
import com.illuminati.ebs.service.IngredienteStockActualService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ingrediente-stock-actuals")
public class IngredienteStockActualController extends GenericController<IngredienteStockActualDto, Long>{
    public IngredienteStockActualController(IngredienteStockActualService service) {
        super(service);
    }
}
