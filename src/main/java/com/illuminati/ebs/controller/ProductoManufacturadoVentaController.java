package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.ProductoManufacturadoVentaDto;
import com.illuminati.ebs.service.ProductoManufacturadoVentaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos-manufacturados-venta")
public class ProductoManufacturadoVentaController extends GenericController<ProductoManufacturadoVentaDto, Long>{
    public ProductoManufacturadoVentaController(ProductoManufacturadoVentaService service) {
        super(service);
    }
}
