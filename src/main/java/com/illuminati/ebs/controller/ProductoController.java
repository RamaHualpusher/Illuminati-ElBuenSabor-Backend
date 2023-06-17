package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.ProductoDto;
import com.illuminati.ebs.service.ProductoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos-manufacturados")
public class ProductoController extends GenericController<ProductoDto, Long>{
    public ProductoController(ProductoService service) {
        super(service);
    }
}
