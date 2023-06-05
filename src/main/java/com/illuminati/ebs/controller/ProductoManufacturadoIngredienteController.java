package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.ProductoManufacturadoIngredienteDto;
import com.illuminati.ebs.service.ProductoManufacturadoIngredienteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producto-manufacturado-ingredientes")
public class ProductoManufacturadoIngredienteController extends GenericController<ProductoManufacturadoIngredienteDto, Long>{
    public ProductoManufacturadoIngredienteController(ProductoManufacturadoIngredienteService service) {
        super(service);
    }
}
