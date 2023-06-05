package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.ProductoManufacturadoCostoDto;
import com.illuminati.ebs.service.ProductoManufacturadoCostoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producto-manufacturado-costos")
public class ProductoManufacturadoCostoController extends GenericController<ProductoManufacturadoCostoDto, Long>{
    public ProductoManufacturadoCostoController(ProductoManufacturadoCostoService service) {
        super(service);
    }
}
