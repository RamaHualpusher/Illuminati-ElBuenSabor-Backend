package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.ProductoDto;
import com.illuminati.ebs.entity.Producto;
import com.illuminati.ebs.service.ProductoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producto")
public class ProductoController extends GenericController<Producto, Long>{
    public ProductoController(ProductoService service) {
        super(service);
    }
}
