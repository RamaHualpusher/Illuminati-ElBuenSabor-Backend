package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.ProductoBebidaVentaDto;
import com.illuminati.ebs.service.ProductoBebidaVentaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producto-bebida-ventas")
public class ProductoBebidaVentaController extends GenericController<ProductoBebidaVentaDto, Long>{
    public ProductoBebidaVentaController(ProductoBebidaVentaService service) {
        super(service);
    }
}
