package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.ProductoIngredienteDto;
import com.illuminati.ebs.service.ProductoIngredienteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producto-ingrediente")
public class ProductoIngredienteController extends GenericController<ProductoIngredienteDto, Long>{
    public ProductoIngredienteController(ProductoIngredienteService service) {
        super(service);
    }
}
