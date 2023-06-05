package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.ProductoBebidaCostoDto;
import com.illuminati.ebs.service.ProductoBebidaCostoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producto-bebida-costos")
public class ProductoBebidaCostoController extends GenericController<ProductoBebidaCostoDto, Long>{
    public ProductoBebidaCostoController(ProductoBebidaCostoService service) {
        super(service);
    }
}
