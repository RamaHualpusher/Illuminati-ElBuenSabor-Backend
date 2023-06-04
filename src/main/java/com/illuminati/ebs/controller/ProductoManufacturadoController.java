package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.ProductoManufacturadoDto;
import com.illuminati.ebs.service.ProductoManufacturadoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductoManufacturadoController extends GenericController<ProductoManufacturadoDto, Long> {

    public ProductoManufacturadoController(ProductoManufacturadoService service) {
        super(service);
    }
}
