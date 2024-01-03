package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.ProductoIngredienteDto;
import com.illuminati.ebs.entity.Producto_Ingrediente;
import com.illuminati.ebs.service.ProductoIngredienteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producto-ingrediente")
@CrossOrigin(origins = "*")
public class ProductoIngredienteController extends GenericController<Producto_Ingrediente, Long>{
    public ProductoIngredienteController(ProductoIngredienteService service) {
        super(service);
    }
}
