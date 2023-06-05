package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.ProductoBebidaStockActualDto;
import com.illuminati.ebs.service.ProductoBebidaStockActualService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producto-bebida-stock-actual")
public class ProductoBebidaStockActualController extends GenericController<ProductoBebidaStockActualDto, Long>{
    public ProductoBebidaStockActualController(ProductoBebidaStockActualService service) {
        super(service);
    }
}
