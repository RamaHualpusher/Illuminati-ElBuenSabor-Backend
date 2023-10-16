package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.ProductoDto;
import com.illuminati.ebs.dto.ProductoRanking;
import com.illuminati.ebs.entity.Producto;
import com.illuminati.ebs.exception.ErrorResponse;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController extends GenericController<Producto, Long>{
    private final ProductoService service;
    public ProductoController(ProductoService service) {
        super(service);
        this.service = service;
    }
    @GetMapping("/ranking")
    public ResponseEntity<?> getTopSellingProducts() {
        try {
            List<ProductoRanking> topSellingProducts = service.findTopSellingProducts();
            return ResponseEntity.ok(topSellingProducts);
        } catch (ServiceException e) {
            // Manejo de excepciones
            ErrorResponse errorResponse = new ErrorResponse(e.getStatus().value(), e.getMessage());
            return ResponseEntity.status(e.getStatus()).body(errorResponse);
        }
    }
}
